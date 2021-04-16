package step2.domain;


import java.util.Random;

public class PointCondition implements Condition {
    private boolean condition;
    private Random random;

    public PointCondition() {
        this.condition = false;
        this.random = new Random();
    }

    public boolean getCondition() {
        this.condition = validate(random.nextBoolean());

        return this.condition;
    }

    private boolean validate(boolean condition) {
        if (condition == true && this.condition == condition) {
            this.condition = false;
            return false;
        }

        return condition;
    }
}
