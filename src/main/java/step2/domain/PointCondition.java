package step2.domain;


public class PointCondition implements Condition {
    private boolean condition;

    public PointCondition(boolean condition) {
        this.condition = false;
    }

    public boolean getCondition(boolean condition) {
        this.condition = validate(condition);

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
