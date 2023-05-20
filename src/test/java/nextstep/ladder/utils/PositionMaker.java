package nextstep.ladder.utils;

import nextstep.ladder.domain.Position;

public class PositionMaker {

    private PositionMaker() {
    }

    public static Position makePosition(int x, int y) {
        return new Position(x,y);
    }

}
