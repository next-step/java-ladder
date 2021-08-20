package nextstep.ladders.domain;

public class Ladder {

    private final Lines lines;

    public Ladder(final Lines lines) {
        this.lines = lines;
    }

    public Ladder(final int countOfPerson, final int height) {
        this.lines = new Lines(countOfPerson, height);
    }

    public Ladder(final int countOfPerson, final String maxLadderHeightText) {
        this.lines = new Lines(countOfPerson, parseMaxLadderHeight(maxLadderHeightText));
    }

    private int parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    public Lines getLines() {
        return lines;
    }
}
