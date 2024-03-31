package nextstep.ladder.domain.player;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        assertNameNotBlankAndLengthUnderFive(name);

        this.name = name;
    }

    private void assertNameNotBlankAndLengthUnderFive(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1글자에서 5글자까지 입력 가능합니다.");
        }
    }

    public String name() {
        return name;
    }


}
