package step4_ladderGame.domain;


public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    private LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public static LadderGame of(String[] names, int height) {

        return new LadderGame(Ladder.of(height, names.length, RandomPointStrategy.getInstance()), Players.of(names));
    }

}
