package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.WrongPlayerException;
import nextstep.ladder.util.StringUtils;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new WrongPlayerException("플레이어 이름은 필수입니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new WrongPlayerException(
                String.format("플레이어 이름이 최대 길이를 초과했습니다. [최대길이: %d자] [입력한 이름: %s]", MAX_NAME_LENGTH, name));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
