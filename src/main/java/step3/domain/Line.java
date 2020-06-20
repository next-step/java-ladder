package step3.domain;

import java.util.Random;

public class Line {
    private static Random random = new Random(System.currentTimeMillis());

    private PointStep pointSetp;
    private boolean canStepable;

    public Line(boolean setAble) {
        this.canStepable = (setAble) && isaBoolean();
    }

    private boolean isaBoolean() {
        return random.nextBoolean();
    }

    public boolean isCanStepable() {
        return canStepable;
    }

    public void removeDirection(PointStep pointStep) {
        if (this.pointSetp == PointStep.RIGHT) {
            canStepable = false;
            this.pointSetp = PointStep.NONE;
        }
    }

    public PointStep getPointStep() {
        return pointSetp;
    }

    public void setPointSetp(PointStep pointSetp, boolean lineStepable) {
        if(lineStepable) {
            this.pointSetp = pointSetp;
        }
    }

    public void setPointSetp(PointStep pointSetp) {
        this.pointSetp = pointSetp;
    }

}
