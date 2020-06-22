package step4.domain;

public enum PointStep {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    NONE("PASS");

    private String direction;

    PointStep(String direction) {
        this.direction = direction;
    }

    public int getStepLocationLR() {
        if (this.equals(PointStep.RIGHT) ) {
            return 1;
        }
        if (this.equals(PointStep.LEFT)) {
            return -1;
        }
        return 0;
    }

}
