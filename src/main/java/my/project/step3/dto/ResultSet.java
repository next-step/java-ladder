package my.project.step3.dto;

import my.project.step3.domain.Reward;

/**
 * Created : 2020-12-09 오후 1:13
 * Developer : Seo
 */
public class ResultSet {
    private final String username;
    private final Reward reward;

    public ResultSet(String username, Reward reward) {
        this.username = username;
        this.reward = reward;
    }

    public String getUsername() {
        return this.username;
    }

    public String getReward() {
        return this.reward.get();
    }
}
