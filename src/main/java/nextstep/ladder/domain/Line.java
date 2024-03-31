package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.List;

public class Line {

    public static final int MINIMUM_PARTICIPANTS_COUNT = 2;
    private final List<StepType> points;

    private Line(int countOfUsers, List<StepType> stepTypes) {
        validate(countOfUsers, stepTypes);

        this.points = stepTypes;
    }

    private void validate(int countOfUsers, List<StepType> strategyResult) {
        if (countOfUsers < MINIMUM_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException(String.format("사용자 수는 %d명 이상이여야 합니다.", MINIMUM_PARTICIPANTS_COUNT));
        }

        if (countOfUsers != (strategyResult.size() + 1)) {
            throw new IllegalArgumentException("사용자 수와 사다리 전략 결과의 검증에 실패했습니다.");
        }

        validateStepStrategy(strategyResult);
    }

    private void validateStepStrategy(List<StepType> strategyResult) {
        for (int i = 1; i < strategyResult.size(); i++) {
            validateContinuedStep(strategyResult, i);
        }
    }

    private static void validateContinuedStep(List<StepType> strategyResult, int currentIndex) {
        if (strategyResult.get(currentIndex - 1) == StepType.STEP && strategyResult.get(currentIndex) == StepType.STEP) {
            throw new IllegalArgumentException("올바르지 못한 LineStrategy 입니다.");
        }
    }

    public static Line of(int countOfUsers, List<StepType> stepTypes) {
        return new Line(countOfUsers, stepTypes);
    }

    public List<StepType> toList() {
        return List.copyOf(points);
    }

    public StepType getStepTypeOfIndex(int index) {
        return this.points.get(index);
    }
}
