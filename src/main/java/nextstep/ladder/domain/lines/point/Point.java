package nextstep.ladder.domain.lines.point;

public interface Point {

    Point decideNextPoint(Boolean randomBoolean);

    boolean isPointFalse();

    boolean isPointTrue();
}
