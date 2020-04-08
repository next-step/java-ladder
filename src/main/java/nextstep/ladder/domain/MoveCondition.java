package nextstep.ladder.domain;

@FunctionalInterface
public interface MoveCondition {

    boolean isMove(int position);
}
