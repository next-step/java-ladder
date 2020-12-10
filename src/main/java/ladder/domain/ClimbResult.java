package ladder.domain;

public class ClimbResult {

    private Player player;

    private Award award;

    private ClimbResult(Player player, Award award){
        this.player = player;
        this.award = award;
    }

    public static ClimbResult of(Player player, Award award){
        return new ClimbResult(player, award);
    }

    public Player getPlayer() {
        return player;
    }

    public Award getAward() {
        return award;
    }
}
