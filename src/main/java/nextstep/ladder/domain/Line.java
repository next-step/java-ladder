package nextstep.ladder.domain;

public interface Line {
    void move(Position position);

    boolean canMove();
}
