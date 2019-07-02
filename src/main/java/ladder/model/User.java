package ladder.model;

import ladder.enumSet.Validation;

public class User {

    private String name;

    public User(String name) {
        this.name = nameValidation(name);
    }

    public String getName() {
        return this.name;
    }

    public int getNameLength() {
        return this.name.length();
    }

    private String nameValidation(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
        }
        return nameCharactersValidation(name);
    }

    private String nameCharactersValidation(String name) {
        if (Validation.NAME_VALIDATE.isInValid(name)) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 영문으로만 입력 할 수 있습니다.");
        }
        return name;
    }

}
