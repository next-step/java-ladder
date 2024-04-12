package ladder.domain;

import ladder.util.RandomUtil;

public class Point {
    private boolean bridge;

    public Point() {
        this.bridge = RandomUtil.booleanRandom();
    }

    public Point(boolean bridge) {
        this.bridge = bridge;
    }

    public boolean exist(){
        return this.bridge;
    }
}
