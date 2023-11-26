package nextstep.step4.inout.common;

import nextstep.step4.inout.domain.*;

import java.util.List;

public class Common {
    public static Ladder makeDefaultLadder() {
        final UserData userData = new UserData(
                new UserInputTexts("pobi,honux,crong,jk"),
                new UserInputTexts("꽝,5000,꽝,3000")
        );
        final LadderHeight ladderHeight = new LadderHeight(5);

        return new Ladder(userData, ladderHeight);
    }

    /**
     * TrueFalseTrueLine
     * -> true, false, true Line <p/>
     *
     * <pre>
     * |-----|     |-----|
     * </pre>
     */
    public static List<Point> buildTrueFalseTrueLine() {
        return List.of(
                buildFirstTruePoint(),
                buildTrueFalsePoint(),
                buildFalseTruePoint(),
                buildTrueFalsePoint()
        );
    }

    public static Point buildFirstTruePoint() {
        return Point.first(true);
    }

    public static Point buildFalseTruePoint() {
        return Point.first(true);
    }

    public static Point buildTrueFalsePoint() {
        return Point.first(true).next(false);
    }

    public static Point buildFalseFalsePoint() {
        return Point.first(false).last();
    }
}
