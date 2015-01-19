package org.example.beans;

import org.example.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Wesley on 1/13/2015.
 */
public class Team {
    String name;
    String tag; //Short version: Na'vi instead of Natus Vincere
    String logoUrl;

    //TODO: Add players and such

    public Team() {
    }

    public Team(String name, String tag, String logoUrl) {
        this.name = name;
        this.tag = tag;
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }

    public Team(JSONObject teamJson) throws JSONException {
        name = teamJson.getString("team_name");
        tag = teamJson.getString("team_tag");
        logoUrl = Constants.DAILY_DOTA_URL + teamJson.getString("logo_url");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
