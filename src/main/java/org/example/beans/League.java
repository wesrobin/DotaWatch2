package org.example.beans;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Wesley on 1/13/2015.
 */
public class League {
    int ddId;
    int valveId;
    String name;
    String imageUrl;
    boolean hasTicket;

    //TODO: Link to bracket

    public League() {
    }

    public League(int ddId, int valveId, String name, String imageUrl, boolean hasTicket) {
        this.ddId = ddId;
        this.valveId = valveId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.hasTicket = hasTicket;
    }

    @Override
    public String toString() {
        return "League{" +
                "ddId=" + ddId +
                ", valveId=" + valveId +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", hasTicket=" + hasTicket +
                '}';
    }

    public League(JSONObject leagueJson) throws JSONException {
        ddId = leagueJson.getInt("id");
        valveId = leagueJson.getInt("league_id");
        name = leagueJson.getString("name");
        imageUrl = leagueJson.getString("image_url");
        hasTicket = leagueJson.getInt("has_ticket") == 1;
    }

    public int getDdId() {
        return ddId;
    }

    public void setDdId(int ddId) {
        this.ddId = ddId;
    }

    public int getValveId() {
        return valveId;
    }

    public void setValveId(int valveId) {
        this.valveId = valveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }
}
