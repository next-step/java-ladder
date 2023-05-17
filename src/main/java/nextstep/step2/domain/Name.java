package nextstep.step2.domain;

public class Name {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
