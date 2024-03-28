package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.List;

@FunctionalInterface
public interface StepStrategy {
    List<StepType> execute(int countOfUsers);
}
