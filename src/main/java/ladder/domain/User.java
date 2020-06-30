package ladder.domain;

import ladder.utils.InputUtils;

public class User {

    private final int MAX_NAME_LENGTH = 5;
    private String name;

    public User(String inputName) {
        InputUtils.isEmptyOrNull(inputName);
        if (inputName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = inputName;
    }
}
