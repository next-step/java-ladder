package ladder.model;

import ladder.exception.WrongParameterException;

import java.util.Optional;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        this.name = Optional.of(name)
                .filter(value -> value.length() <= MAX_NAME_LENGTH)
                .orElseThrow(() -> new WrongParameterException("[입력 오류] 플레이어의 이름은 최대 5자 입니다."));
    }

    public String getName() {
        return name;
    }
}
