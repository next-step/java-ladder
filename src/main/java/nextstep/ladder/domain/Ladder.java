package nextstep.ladder.domain;

public class Ladder {

    private Line line;

    public Ladder(String[] playerNames, int ladderHeight) {
        this.line = new Line(playerNames.length);
    }
}
