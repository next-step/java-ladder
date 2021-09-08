package nextstep.ladder.domain;

public class LadderGameMain {

    private final Ladder ladder;

    public LadderGameMain(LadderGameSettings gameSettings) {
        this.ladder = Ladder.from(gameSettings.getDrawingSettings());
    }

    public void playGame() {

    }

    public Ladder getLadder() {
        return ladder;
    }
}
