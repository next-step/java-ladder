package nextstep.ladder.model;

import java.util.Objects;

public class Step {

    private static final RandomLineGenerator randomLineGenerator = RandomLineGenerator.getInstance();
    private final Boolean step;

    public Step() {
        this.step = randomLineGenerator.randomStep();
    }

    private Step(boolean step) {
        this.step = step;
    }

    public static Step emptyStep() {
        return new Step(false);
    }

    public Step overlapStepReplace(Step previousStep) {
        if (this.equals(previousStep) && previousStep.step.equals(true)) {
            return new Step(false);
        }
        return new Step(this.step);
    }

    public boolean canMove(){
        return this.step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Step step1 = (Step) o;
        return Objects.equals(step, step1.step);
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
