package nextstep.ladder.domain;

public class Reward {
    private String name;
    private Player player;

    public Reward(String rewardName, Player player) {
        this.name = rewardName;
        this.player = player;
    }
}
