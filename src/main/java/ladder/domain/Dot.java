package ladder.domain;

public class Dot {
    private final boolean value;
    private static int ONE = 1;
    private static int ZERO = 0;
    private static int MINUS_ONE = -1;

    public Dot(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public int getMoveStep() {
        if (value) {
            return ONE;
        }
        return ZERO;
    }

    public int getMoveStepWithPreDot(boolean preIndexValue) {
        if (preIndexValue) {
            return MINUS_ONE;
        }
        if (value) {
            return ONE;
        }
        return ZERO;
    }

    @Override
    public boolean equals(Object obj) {
        Dot dot = (Dot) obj;
        return this.value == dot.value;
    }
}
