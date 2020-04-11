package ladder.domain;


import java.util.Arrays;

public enum SteerRule {
    RIGHT(1),
    STOP(0),
    LEFT(-1);

    private int steer;

    SteerRule(int steer) {
        this.steer = steer;
    }

    public int getSteer() {
        return steer;
    }

    public static SteerRule direction(int steer) {
        return Arrays.stream(SteerRule.values())
                .filter(steerRule -> steerRule.getSteer() == steer)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(steer + " 잘 못 된 이동입니다."));
    }
}
