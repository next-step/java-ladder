package nextstep.step3.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 03:11
 */
public class Link {
    public static final int INCREASE = 1;
    public static final int DECREASE = 1;
    public static final int DEFAULT_INDEX = 0;
    private static final String CREATE_FIRST_INDEX_EXCEPTION_MESSAGE = "왼쪽노드가 유효하지 않습니다. (0번째 Link의 왼쪽노드는 flase만 허용합니다.)";
    private static final String CREATE_SAME_STATUS_EXCEPTION_MESSAGE = "현재 Link와 Left Link가 모두 true면 안됩니다.";

    private final int index;
    private final boolean link;
    private final boolean left;

    public Link(int index, boolean link, boolean left) {
        if (index == DEFAULT_INDEX && left) {
            throw new IllegalArgumentException(CREATE_FIRST_INDEX_EXCEPTION_MESSAGE);
        }
        if (link && left) {
            throw new IllegalArgumentException(CREATE_SAME_STATUS_EXCEPTION_MESSAGE);
        }
        this.index = index;
        this.link = link;
        this.left = left;
    }

    public static Link first(RandomGenerator random) {
        return new Link(DEFAULT_INDEX, random.generate(), false);
    }

    public static Link next(Link leftLink, RandomGenerator random) {
        return new Link(leftLink.index + INCREASE, random.generate(), leftLink.link);
    }

    public static Link last(Link leftLink) {
        return new Link(leftLink.index + INCREASE, false, leftLink.link);
    }

    public boolean matchIndex(int index) {
        return this.index == index;
    }

    public boolean status() {
        return this.link;
    }

    public int move() {
        if (link) {
            return index + INCREASE;
        }
        if (left) {
            return index - DECREASE;
        }
        return index;
    }
}
