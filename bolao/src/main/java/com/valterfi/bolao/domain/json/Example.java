package com.valterfi.bolao.domain.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venue",
    "location",
    "status",
    "time",
    "fifa_id",
    "datetime",
    "last_event_update_at",
    "last_score_update_at",
    "home_team",
    "away_team",
    "winner",
    "winner_code",
    "home_team_events",
    "away_team_events"
})
public class Example {

    @JsonProperty("venue")
    private String venue;
    @JsonProperty("location")
    private String location;
    @JsonProperty("status")
    private String status;
    @JsonProperty("time")
    private String time;
    @JsonProperty("fifa_id")
    private String fifaId;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("last_event_update_at")
    private String lastEventUpdateAt;
    @JsonProperty("last_score_update_at")
    private String lastScoreUpdateAt;
    @JsonProperty("home_team")
    private HomeTeam homeTeam;
    @JsonProperty("away_team")
    private AwayTeam awayTeam;
    @JsonProperty("winner")
    private Object winner;
    @JsonProperty("winner_code")
    private Object winnerCode;
    @JsonProperty("home_team_events")
    private List<HomeTeamEvent> homeTeamEvents = null;
    @JsonProperty("away_team_events")
    private List<AwayTeamEvent> awayTeamEvents = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("venue")
    public String getVenue() {
        return venue;
    }

    @JsonProperty("venue")
    public void setVenue(String venue) {
        this.venue = venue;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("fifa_id")
    public String getFifaId() {
        return fifaId;
    }

    @JsonProperty("fifa_id")
    public void setFifaId(String fifaId) {
        this.fifaId = fifaId;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("last_event_update_at")
    public String getLastEventUpdateAt() {
        return lastEventUpdateAt;
    }

    @JsonProperty("last_event_update_at")
    public void setLastEventUpdateAt(String lastEventUpdateAt) {
        this.lastEventUpdateAt = lastEventUpdateAt;
    }

    @JsonProperty("last_score_update_at")
    public String getLastScoreUpdateAt() {
        return lastScoreUpdateAt;
    }

    @JsonProperty("last_score_update_at")
    public void setLastScoreUpdateAt(String lastScoreUpdateAt) {
        this.lastScoreUpdateAt = lastScoreUpdateAt;
    }

    @JsonProperty("home_team")
    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("home_team")
    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("away_team")
    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("away_team")
    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    @JsonProperty("winner")
    public Object getWinner() {
        return winner;
    }

    @JsonProperty("winner")
    public void setWinner(Object winner) {
        this.winner = winner;
    }

    @JsonProperty("winner_code")
    public Object getWinnerCode() {
        return winnerCode;
    }

    @JsonProperty("winner_code")
    public void setWinnerCode(Object winnerCode) {
        this.winnerCode = winnerCode;
    }

    @JsonProperty("home_team_events")
    public List<HomeTeamEvent> getHomeTeamEvents() {
        return homeTeamEvents;
    }

    @JsonProperty("home_team_events")
    public void setHomeTeamEvents(List<HomeTeamEvent> homeTeamEvents) {
        this.homeTeamEvents = homeTeamEvents;
    }

    @JsonProperty("away_team_events")
    public List<AwayTeamEvent> getAwayTeamEvents() {
        return awayTeamEvents;
    }

    @JsonProperty("away_team_events")
    public void setAwayTeamEvents(List<AwayTeamEvent> awayTeamEvents) {
        this.awayTeamEvents = awayTeamEvents;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
