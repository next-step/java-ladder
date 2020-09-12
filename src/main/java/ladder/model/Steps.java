package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Steps {

    private final List<Step> steps;

    private Steps(List<Step> steps) {
        this.steps = steps;
    }

    public static Steps of(int countOfSteps, LadderGenerateStrategy generateStrategy) {
        validateCountOfSteps(countOfSteps);
        List<Step> stepList = new ArrayList<>();

        Step firstStep = initFirst(stepList, generateStrategy);
        Step beforeLastStep = initSteps(stepList, firstStep, countOfSteps, generateStrategy);
        initLast(stepList, beforeLastStep);

        return new Steps(stepList);
    }

    private static void validateCountOfSteps(int countOfSteps) {
        if (countOfSteps < 2) {
            throw new IllegalArgumentException("step은 최소 두 개 이상입니다.");
        }
    }

    private static Step initFirst(List<Step> steps, LadderGenerateStrategy generateStrategy) {
        Step firstStep = Step.first(generateStrategy.generate());
        steps.add(firstStep);

        return firstStep;
    }

    private static Step initSteps(List<Step> steps, Step step, int countOfSteps, LadderGenerateStrategy generateStrategy) {
        for (int i = 1; i < countOfSteps - 1; i++) {
            step = step.next(generateStrategy.generate());
            steps.add(step);
        }

        return step;
    }

    private static void initLast(List<Step> steps, Step beforeStep) {
        steps.add(beforeStep.last());
    }

    public int move(int position) {
        validPosition(position);
        return steps.get(position).move();
    }

    private void validPosition(int position) {
        if (position < 0 || position >= steps.size()) {
            throw new IllegalArgumentException("위치가 사다리 범위를 벗어났습니다.");
        }
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

}
