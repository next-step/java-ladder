package nextstep.ladder.domain;

public class LadderGameSettings {

    private final Players players;
    private final LadderSize ladderSize;


    private LadderGameSettings(Players players, LadderSize ladderSize) {
        this.players = players;
        this.ladderSize = ladderSize;
    }

    public static LadderGameSettings of(Players players, LadderSize ladderSize) {
        return new LadderGameSettings(players, ladderSize);
    }

}
