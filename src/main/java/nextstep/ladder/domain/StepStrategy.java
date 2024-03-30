package nextstep.ladder.domain;

@FunctionalInterface
public interface StepStrategy {
    Line execute(int countOfUsers);
}
