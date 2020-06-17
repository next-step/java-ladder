package nextstep.ladder.domain.player;

public class Name {
    public static final int NAME_UPPER_BOUND = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름에 빈 문자가 들어가면 안됩니다.");
        }

        if(name.length() > NAME_UPPER_BOUND) {
            throw new IllegalArgumentException(String.format("이름은 %d 글자를 넘으면 안됩니다.", NAME_UPPER_BOUND));
        }
    }

    public String toString() {
        return String.format("%" + NAME_UPPER_BOUND + "s", name);
    }
}
