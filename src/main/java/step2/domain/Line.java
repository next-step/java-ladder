package step2.domain;

import java.util.Random;

public class Line {

    private boolean step;

    private static Random random = new Random(System.currentTimeMillis());

    public Line(boolean setAble) {
        this.step = (setAble) && random.nextBoolean();
    }

    public boolean isStep() {
        return step;
    }

    public void removeDirection(Pointer pointer) {

        if (pointer == Pointer.RIGHT) {
            step = false;
        }

    }

}
