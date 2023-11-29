package nextstep.ladder.model;

public class Name {

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1자 ~ 5자 입니다");
        }
    }
}
