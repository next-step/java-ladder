package nextstep.ladder.doman;

public class PointDirection {

    private boolean hasPrevious;

    public PointDirection(Point previousPoint) {
        validate(previousPoint);
        this.hasPrevious = previousPoint.isConnected();
    }

    private void validate(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("이전 Point는 null일 수 없습니다.");
        }
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }
}
