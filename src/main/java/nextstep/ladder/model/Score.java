package nextstep.ladder.model;

public class Score {

    private final Player player;
    private final Integer score;

    public Score(Player player, int score) {
        this.player = player;
        this.score = score;
    }

    public static Score of(Player player, int result) {
        return new Score(player, result);
    }

    public int intScore() {
        return score;
    }

    public Score addSCore() {
        return new Score(this.player, this.score + 1);
    }

    public Score minusScore() {
        return new Score(this.player, this.score - 1);
    }

    public Player player() {
        return player;
    }
}
