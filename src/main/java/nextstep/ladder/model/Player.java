package nextstep.ladder.model;

import java.util.Optional;

public class Player extends Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String EXCEPTION_NAME_MAX_LENGTH_OVER = "사람 이름은 5글자를 초과할 수 없습니다.";

    public Player(String name) {
        super(name);
    }

    @Override
    protected String validation(String name) {
        return Optional.ofNullable(name)
                .filter(n -> n.length() <= NAME_MAX_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NAME_MAX_LENGTH_OVER));
    }
}
