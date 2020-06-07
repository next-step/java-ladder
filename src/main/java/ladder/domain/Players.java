package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<String> playerNames;

    public Players(final String[] personNames) {
        validate(personNames);
        this.playerNames = Arrays.stream(personNames).collect(Collectors.toList());
    }

    private void validate(String[] personNames) {
        Arrays.stream(personNames).forEach(v -> {
            if (v.length() > 5) {
                throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입니다.");
            }
        });
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
