package nextstep.ladder.util;

public class LadderUtils {

    public static boolean isOpenBridge(boolean isPrevOpen, boolean thisPoint) {
        return (!isPrevOpen && thisPoint) ? true : false;
    }
}
