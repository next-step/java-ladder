package nextstep.ladder.domain.line.player;

public class Name {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateName(name);
    }

    private void validateLength(String name) {
        if (name == null || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 다섯 글자까지 허용됩니다.");
        }
    }

    private void validateName(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("all 은 이름으로 사용할 수 없습니다.");
        }
    }

}
