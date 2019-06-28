package nextstep.ladder.domain;

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

    private static final int RANGE_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name of(String targetName) {
        if(targetName.length() > RANGE_NAME_LENGTH ) {
            throw new IllegalArgumentException("사용자 이름은 5글자 이하만 가능합니다.");
        }
        return new Name(targetName);
    }

    /*
    궁금증 2)

    return this.equals(sourceName); 으로 구현했을 경우 비교가 안되나요?
    equals()를 오버라이딩 해서 사용중이고 console에도 hashcode의 주소값이 같게 되어있는데 false로만 떨어지네요.
     */
    public boolean isName(Name sourceName) {
//        return this.equals(sourceName);
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

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
