package step2.model;

public class User {
    private String name;

    public User(String name) {
        isBlank(name);
        this.name = name.trim();
    }

    private void isBlank(String usersName) {
        if (usersName == null || usersName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비었습니다. 다시 입력해주세요");
        }
    }
}
