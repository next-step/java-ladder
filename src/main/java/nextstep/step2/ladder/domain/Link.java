package nextstep.step2.ladder.domain;

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
    private final boolean link;

    private Link(boolean link) {
        this.link = link;
    }

    public static Link of(boolean link) {
        return new Link(link);
    }

    public boolean status() {
        return this.link;
    }

    @Override
    public String toString() {
        return link + "";
    }
}
