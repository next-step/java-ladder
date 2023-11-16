package me.namuhuchutong.ladder.domain.wrapper;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 크기는 5자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
