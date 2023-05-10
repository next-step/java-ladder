package nextstep.ladder.domain.ladder;

public class Ladder {

    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Lines getLineColumns() {
        return lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lineColumns=" + lines +
                '}';
    }

}
