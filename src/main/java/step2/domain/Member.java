package step2.domain;

import step2.util.StringUtils;

public class Member {
    private final static int NAME_MAX_LENGTH = 5;
    private final String name;

    public Member(String name) {
        validationName(name);
        this.name = name;
    }

    private void validationName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자까지 가능합니다.");
        }
    }
}
