package ladder.domain;

public class LineTypeDTO {

    private int point;
    private PossibilityStrategy possibilityStrategy;
    private boolean checkPrePoint;

    public LineTypeDTO(int point, PossibilityStrategy possibilityStrategy, boolean checkPrePoint) {
        this.point = point;
        this.possibilityStrategy = possibilityStrategy;
        this.checkPrePoint = checkPrePoint;
    }

    public int getPoint() {
        return point;
    }

    public PossibilityStrategy getPossibilityStrategy() {
        return possibilityStrategy;
    }

    public boolean isCheckPrePoint() {
        return checkPrePoint;
    }
}
