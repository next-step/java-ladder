package my.project.dto;

import my.project.domain.Reward;

/**
 * Created : 2020-12-09 오후 1:13
 * Developer : Seo
 */
public class Result {
    private final String username;
    private final Reward reward;

    public Result(String username, Reward reward) {
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
