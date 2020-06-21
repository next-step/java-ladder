package nextstep.ladder.domain;

public class LadderGamePlay {

    private Ladder ladder;

    private LadderGamePlay(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderGamePlay of(Ladder ladder) {
        return new LadderGamePlay(ladder);
    }

    public ExecutionResult playLadderGame(Player player) {

        Point point = player.point();

        Point result = ladder.playLadderGame(point);
        System.out.println(result.getxAxis() + " " + result.getyAxis());
        return null;
    }
}
