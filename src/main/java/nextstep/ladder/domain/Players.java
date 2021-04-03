package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    public final static int FIRST_POSITION = 1;
    private List<Player> players;

    public Players(String value) {
        validation(value);
        players = generatePlayers(value.split(","));
    }

    public void validation(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("참가자의 이름은 비어있는 값 일 수 없습니다.");
        }
    }

    private List<Player> generatePlayers(String[] values) {
        return Arrays.stream(values)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return players.size();
    }

    public String names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.joining(" "));
    }
}
