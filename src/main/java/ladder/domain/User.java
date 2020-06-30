package ladder.domain;

import ladder.utils.InputUtils;

import java.util.Collections;
import java.util.List;

public class User {

    private final int MAX_NAME_LENGTH = 5;
    private final String BLANK = " ";
    private String name;

    public User(String inputName) {
        InputUtils.isEmptyOrNull(inputName);
        if (inputName.length() > MAX_NAME_LENGTH) {
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
