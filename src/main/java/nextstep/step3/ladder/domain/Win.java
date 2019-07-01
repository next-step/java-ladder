package nextstep.step3.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 22:24
 */
public class Win {
    private static final String NULL_EMPTY_EXCEPTION_MESSAGE = "결과가 입력이 안되었습니다.";
    private static final String UNDER_WIN_NUMBER = "입력된 결과가 0보다 작습니다.";

    private static final Win NOT_WIN = new Win("꽝");
    private final String win;

    private Win(String win) {
        this.win = win;
    }

    public static Win of(String win) {
        if (win == null || win.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        if("꽝".equals(win)) {
            return NOT_WIN;
        }
        return new Win(win);
    }

    public static Win of(int win) {
        if (win < 0) {
            throw new IllegalArgumentException(UNDER_WIN_NUMBER);
        }
        return new Win(String.valueOf(win));
    }

    public String getWin() {
        return this.win;
    }
}
