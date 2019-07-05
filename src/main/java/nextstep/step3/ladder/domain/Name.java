package nextstep.step3.ladder.domain;

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

    private static final int RANGE_NAME_MAX_LENGTH = 5;
    private static final int RANGE_NAME_MIN_LENGTH = 1;
    private static final String EXCEPTION_MESSAGE_FORMANT = "사용자의 이름이 유효하지 않습니다. (1~5글자만 입력가능)";

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String targetName) {
        if (targetName.length() > RANGE_NAME_MAX_LENGTH
                || targetName.length() < RANGE_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FORMANT);
        }
        return new Name(targetName);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }
}
