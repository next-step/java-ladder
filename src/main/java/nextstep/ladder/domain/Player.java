package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayerDto;

public class Player {

    private static final int NAME_MAXIMUM_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 다섯 글자까지 허용됩니다.");
        }
    }

    public PlayerDto export() {
        return new PlayerDto(name);
    }
}
