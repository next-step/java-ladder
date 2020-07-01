package ladder.domain;

import ladder.utils.InputUtils;

import java.util.Collections;

public class User {

    private final static int MAX_NAME_LENGTH = 5;
    private final static String BLANK = " ";
    private String name;

    public User(String inputName) {
        String name = InputUtils.isEmptyOrNull(inputName);
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = inputName;
    }

    @Override
    public String toString() {
        int needBlank = MAX_NAME_LENGTH - name.length();
        return String.join("", Collections.nCopies(needBlank, BLANK)) + name;
    }
}
