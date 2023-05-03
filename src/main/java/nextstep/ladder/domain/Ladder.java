package nextstep.ladder.domain;

public class Ladder {

    private final LineColumns lineColumns;

    private Ladder(LineColumns lineColumns) {
        this.lineColumns = lineColumns;
    }

    public static Ladder create(LadderHeight ladderHeight, Participants participants) {
        return new Ladder(LineColumns.create(
                ladderHeight.getHeight(),
                participants.count()));
    }

    public LineColumns getLineColumns() {
        return lineColumns;
    }

}
