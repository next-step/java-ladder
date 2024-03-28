package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    public static final int MINIMUM_PARTICIPANTS_COUNT = 2;
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = FIRST_INDEX + 1;
    private final List<StepType> points;

    public static Line of(int countOfUsers, StepStrategy strategy) {
        return new Line(countOfUsers, strategy);
    }

    private Line(int countOfUsers, StepStrategy strategy) {
        List<StepType> strategyResult = strategy.execute(countOfUsers);
        validate(countOfUsers, strategyResult);

        List<StepType> stepTypes = new ArrayList<>();
        stepTypes.add(strategyResult.get(FIRST_INDEX));

        IntStream.range(SECOND_INDEX, strategyResult.size())
                .forEach(index -> {
                    stepTypes.add(step(strategyResult.get(index), stepTypes.get(index - 1)));
                });
        this.points = stepTypes;
    }

    private void validate(int countOfUsers, List<StepType> strategyResult) {
        if (countOfUsers < MINIMUM_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException("사용자 수는 2명 이상이여야 합니다.");
        }

        if (countOfUsers != (strategyResult.size() + 1)) {
            throw new IllegalArgumentException("사용자 수와 사다리 전략 결과의 검증에 실패했습니다.");
        }
    }

    private StepType step(StepType nowStrategyStep, StepType beforeStep) {
        if (nowStrategyStep == StepType.STEP && beforeStep != StepType.STEP) {
            return nowStrategyStep;
        }
        return StepType.EMPTY;
    }

    public List<StepType> toList() {
        return List.copyOf(points);
    }
}
