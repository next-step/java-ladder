package ladder.domain;

import ladder.utils.StringUtil;

public class Name {

    private static final Integer MAX_LENGTH = 5;
    private String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        validate(name);
        return new Name(name);
    }

    private static void nameToMaxLengthValidate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참여할 사람 이름 최대 길이는 " + MAX_LENGTH + "글자 입니다.");
        }
    }

    private static void validate(String name) {
        nameToMaxLengthValidate(name);
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("참여할 사람 이름을 입력해주세요.");
        }
    }

    public String getName() {
        return this.name;
    }
}
