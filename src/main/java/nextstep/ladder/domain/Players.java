package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayersDto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Players {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String DELIMITER = ",";

    private final Map<Player, Integer> playerMap;

    public Players(final String names) {
        validateNames(names);
        AtomicInteger index = new AtomicInteger();
        playerMap = Arrays.stream(names.split(DELIMITER))
                .map(Player::new)
                .collect(toMap(Function.identity(), v -> index.getAndIncrement(), (x, y) -> y, LinkedHashMap::new));
    }

    public PlayersDto toDto() {
        return new PlayersDto(playerMap.keySet()
                .stream()
                .map(Player::toDto)
                .collect(Collectors.toList()));
    }

    public int count() {
        return playerMap.size();
    }

    private void validateNames(final String names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
