package nextstep.ladder.domain;

public class Ladder {

    private final LineColumns lineColumns;

    public Ladder(LineColumns lineColumns) {
        this.lineColumns = lineColumns;
    }

    public LineColumns getLineColumns() {
        return lineColumns;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lineColumns=" + lineColumns +
                '}';
    }

}
