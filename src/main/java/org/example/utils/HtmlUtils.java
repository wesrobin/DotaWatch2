package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Wesley on 1/13/2015.
 */
public class HtmlUtils {
    public static InputStream getRequest (String url, String[] params, String charset) throws IOException {
        InputStream response;
        if (params.length != 0) {
            String query = convertParamsToQuery(params, charset);

            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);

            response = connection.getInputStream();
        } else {
            System.out.println("here");
            response = new URL(url).openStream();
        }

        return response;
    }

    public static InputStream postRequest (String url, String[] params, String charset) throws IOException {
        String query = convertParamsToQuery(params, charset);

        URLConnection connection = new URL(url).openConnection();
        connection.setDoInput(true);    //Triggers POST
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

        OutputStream output = connection.getOutputStream();
        output.write(query.getBytes(charset));

        InputStream response = connection.getInputStream();

        return response;
    }

    private static String convertParamsToQuery (String[] params, String charset) throws UnsupportedEncodingException {
        String query = "";
        for (int i = 0; i < params.length; i++) {
            query += "param" + (i + 1) + "=" + URLEncoder.encode(params[i], charset);
        }
        return query;
    }
}
