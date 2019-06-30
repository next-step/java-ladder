package nextstep.step2.ladder.domain;

import java.util.Objects;

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
    private static final int PRINT_NAME_FIVE_LETTER_INDXE_RANGE = 6;
    private static final String PRINT_NAME_FIVE_LETTER_MATCH_SPACE = " ";
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name of(String targetName) {
        if (targetName.length() > RANGE_NAME_MAX_LENGTH || targetName.length() < RANGE_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("사용자 이름은 0글자 이상, 5글자 이하만 가능합니다.");
        }
        return new Name(targetName);
    }

    /*
    궁금증 2)

    return this.equals(sourceName); 으로 구현했을 경우 비교가 안되나요?
    equals()를 오버라이딩 해서 사용중이고 console에도 hashcode의 주소값이 같게 되어있는데 false로만 떨어지네요.
     */
    public boolean isName(Name sourceName) {
        return name.equals(sourceName.name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*
    출력에 필요한 커스터마이징
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        int appendCount = PRINT_NAME_FIVE_LETTER_INDXE_RANGE - name.length();
        for (int i = 0; i < appendCount; i++) {
            sb.append(PRINT_NAME_FIVE_LETTER_MATCH_SPACE);
        }
        return sb.toString();
    }
}
