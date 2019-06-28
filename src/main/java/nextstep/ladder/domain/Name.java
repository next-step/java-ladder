package nextstep.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:26
 */
public class Name {
    private static final int RANGE_NAME_LENGTH = 5;
    private final String name;

    private Name(String name) {
        if(name.length() > RANGE_NAME_LENGTH ) {
            throw new IllegalArgumentException("사용자 이름은 5글자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public static Name of(String targetName) {

        return new Name(targetName);
    }
}
