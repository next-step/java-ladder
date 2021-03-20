package laddarGame.domain;

import java.util.Optional;

public class Name {

    private String playerName;

    public Name(String playerName) {
        Optional.ofNullable(playerName)
                .filter(name -> name.length() < 6)
                .orElseThrow(() -> new IllegalArgumentException("플레이어 이름은 5글자를 초과할 수 없습니다."));
    }
}
