package nextstep.ladder.domain;

@FunctionalInterface
public interface LadderBarStatusDecider {

  LadderBarStatus decide(LadderBarStatus ladderBarStatus);
}
