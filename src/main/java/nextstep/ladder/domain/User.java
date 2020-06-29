package nextstep.ladder.domain;

public class User {
    private final String name;

    public User(String name) {
        validationCheck(name);
        this.name = name;
    }

    private void validationCheck(String name) {
        if (name == null || name.replaceAll(" ", "").length() == 0) {
            throw new IllegalArgumentException("Null 혹은 공백을 입력할 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘길 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
