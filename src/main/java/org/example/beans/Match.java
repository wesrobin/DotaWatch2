package org.example.beans;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.Date;

/**
 * Created by Wesley on 1/13/2015.
 */
public class Match {
    String link;

    Team one, two;

    int status;
    int seriesType;
    int streamViewers;
    int ddViewers;

    String startTime;
    String startTimeUnix;
    int timeDiff;

    League league;

    String comment;

    public Match () {}

    public Match(String link, Team one, Team two, int status, int seriesType, int streamViewers, int ddViewers, String startTime, String startTimeUnix, int timeDiff, League league, String comment) {
        this.link = link;
        this.one = one;
        this.two = two;
        this.status = status;
        this.seriesType = seriesType;
        this.streamViewers = streamViewers;
        this.ddViewers = ddViewers;
        this.startTime = startTime;
        this.startTimeUnix = startTimeUnix;
        this.timeDiff = timeDiff;
        this.league = league;
        this.comment = comment;
    }

    public Match(JSONObject jsonMatch) throws JSONException {
        link = jsonMatch.getString("link");

        one = new Team (jsonMatch.getJSONObject("team1"));
        two = new Team (jsonMatch.getJSONObject("team2"));

        status = jsonMatch.getInt("status");
        seriesType = jsonMatch.getInt("series_type");
        startTime = jsonMatch.getString("starttime");
        startTimeUnix = jsonMatch.getString("starttime_unix");
        timeDiff = jsonMatch.getInt("timediff");

        league = new League(jsonMatch.getJSONObject("league"));
        JSONObject temp = jsonMatch.getJSONObject("viewers");
        streamViewers = temp.getInt("stream");
        ddViewers = temp.getInt("self");

        comment = jsonMatch.getString("comment");
    }

    @Override
    public String toString() {
        return "Match{" +
                "link='" + link + '\'' +
                ", one=" + one +
                ", two=" + two +
                ", status=" + status +
                ", seriesType=" + seriesType +
                ", streamViewers=" + streamViewers +
                ", ddViewers=" + ddViewers +
                ", startTime='" + startTime + '\'' +
                ", startTimeUnix='" + startTimeUnix + '\'' +
                ", timeDiff=" + timeDiff +
                ", league=" + league +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Team getOne() {
        return one;
    }

    public void setOne(Team one) {
        this.one = one;
    }

    public Team getTwo() {
        return two;
    }

    public void setTwo(Team two) {
        this.two = two;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(int seriesType) {
        this.seriesType = seriesType;
    }

    public int getStreamViewers() {
        return streamViewers;
    }

    public void setStreamViewers(int streamViewers) {
        this.streamViewers = streamViewers;
    }

    public int getDdViewers() {
        return ddViewers;
    }

    public void setDdViewers(int ddViewers) {
        this.ddViewers = ddViewers;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeUnix() {
        return startTimeUnix;
    }

    public void setStartTimeUnix(String startTimeUnix) {
        this.startTimeUnix = startTimeUnix;
    }

    public int getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(int timeDiff) {
        this.timeDiff = timeDiff;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
