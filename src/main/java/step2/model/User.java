package step2.model;

import static step2.model.LadderValidator.isBlank;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        isBlank(name);
        isOverMaxLength(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void isOverMaxLength(String name) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 입력 가능합니다.");
        }
    }
    
}
