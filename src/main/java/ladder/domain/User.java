package ladder.domain;

import ladder.utils.InputUtils;

public class User {

    private String name;

    public User(String inputName) {
        InputUtils.isEmptyOrNull(inputName);
        if(inputName.length() > 5){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        name = inputName;
    }
}
