package nextstep.ladder.utils;

public final class LadderPartIndexUtils {

    private LadderPartIndexUtils() { }

    public static boolean isHorizon(int partIndex) {
        return !isEven(partIndex);
    }

    public static boolean isVertical(int partIndex) {
        return isEven(partIndex);
    }

    private static boolean isEven(int index) {
        return (index & 1) == 0;
    }

}
