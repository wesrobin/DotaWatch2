package org.example.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.example.beans.Match;
import org.example.utils.Constants;
import org.example.utils.HtmlUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

public class HelloServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Hello Servlet</h1>");
		response.getWriter().println("session=" + request.getSession(true).getId());

		InputStream dailyDotaResponse = new URL(Constants.DAILY_DOTA_API_URL).openStream();//HtmlUtils.getRequest(Constants.DAILY_DOTA_API_URL, null, Constants.ENCODING_UTF_8);
		
		String dailyDotaResponseStr = IOUtils.toString(dailyDotaResponse, Constants.ENCODING_UTF_8);

        ArrayList<Match> matches = new ArrayList<Match>();

        try {
            JSONObject matchesJson = new JSONObject(dailyDotaResponseStr);
            JSONArray matchesJsonArr = matchesJson.getJSONArray("matches");
            String timestampJson = matchesJson.getString("timestamp");

            for (int i = 0; i < matchesJsonArr.length(); i++) {
                matches.add(new Match(matchesJsonArr.getJSONObject(i)));
            }
        } catch (JSONException e) {
            response.getWriter().println("Caught a JSONException");
            System.err.println(e);
        }

		response.getWriter().println(matches.get(0).toString());
	}
}
