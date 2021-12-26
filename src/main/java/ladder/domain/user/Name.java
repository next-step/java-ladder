package ladder.domain.user;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.trim().length() < MINIMUM_NAME_LENGTH || name.trim().length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MINIMUM_NAME_LENGTH + "자 이상 " + MAXIMUM_NAME_LENGTH + "자 이하로 입력 해주세요");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
