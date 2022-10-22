package ladder.model;

import ladder.exception.WrongParameterException;

import java.util.Optional;

public class Player {

    private String name;

    public Player(String name) {
        this.name = Optional.of(name)
                .filter(value -> value.length() <= 5)
                .orElseThrow(() -> new WrongParameterException("[입력 오류] 플레이어의 이름은 최대 5자 입니다."));
    }

    public String getName() {
        return name;
    }
}
