package step2.model;

public class User {
    private String name;

    private static final int MAX_NAME_LENGTH = 5;

    public User(String name) {
        isBlank(name);
        isOverMaxLength(name);
        this.name = name.trim();
    }

    private void isOverMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 입력 가능합니다.");
        }
    }

    private void isBlank(String usersName) {
        if (usersName == null || usersName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비었습니다. 다시 입력해주세요");
        }
    }

    public String getName() {
        return name;
    }
}
