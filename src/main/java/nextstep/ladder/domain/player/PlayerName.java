package nextstep.ladder.domain.player;

import java.util.Objects;
import nextstep.ladder.dto.PlayerNameDto;

public class PlayerName {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateName(name);
    }

    private void validateLength(String name) {
        if (name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 다섯 글자까지 허용됩니다.");
        }
    }

    private void validateName(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("all 은 이름으로 사용할 수 없습니다.");
        }
    }

    public PlayerNameDto export() {
        return new PlayerNameDto(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerName)) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
