package step3.domain;

import java.util.Random;

public class Line {

    private static Random random = new Random(System.currentTimeMillis());

    private boolean canStepable;

    public Line(boolean setAble) {
        this.canStepable = (setAble) && random.nextBoolean();
    }

    public boolean isCanStepable() {
        return canStepable;
    }

    public void removeDirection(Pointer pointer) {
        if (pointer == Pointer.RIGHT) {
            canStepable = false;
        }
    }

}
