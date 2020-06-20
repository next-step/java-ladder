package nextstep.step2.domain;

import nextstep.step2.util.RandomUtils;

public class LineConnection {
    private final boolean connectionState;

    private LineConnection(boolean connectionState) {
        this.connectionState = connectionState;
    }

    public static LineConnection connectFirstLadder() {
        return new LineConnection(RandomUtils.getRandomBoolean());
    }

    public static LineConnection connectLastLadder() {
        return new LineConnection(false);
    }

    public static LineConnection connectLadder(boolean bool) {
        if (bool) {
            return new LineConnection(false);
        }

        return new LineConnection(RandomUtils.getRandomBoolean());
    }

    public boolean isConnect() {
        return connectionState;
    }

}
