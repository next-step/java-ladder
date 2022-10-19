package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.ladder.Line.MAX_POINTS_SIZE;
import static nextstep.ladder.domain.ladder.Line.MIN_POINTS_SIZE;

public class Players {
    private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복된 이름의 플레이어는 허용하지 않습니다.";
    private static final String PLAYER_SIZE_EXCEPTION_MESSAGE = MIN_POINTS_SIZE + "명 이상 또는 " + MAX_POINTS_SIZE + "이하의 플레이어가 있어야 합니다.";

    private final List<Player> values;

    public Players(List<Player> values) {
        checkSize(values);
        checkDuplicatePlayer(values);

        this.values = values;
    }

    private void checkSize(List<Player> values) {
        if (values.size() < MIN_POINTS_SIZE ||
                values.size() > MAX_POINTS_SIZE) {
            throw new IllegalArgumentException(PLAYER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplicatePlayer(List<Player> values) {
        if (new HashSet<>(values).size() != values.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static Players create(String ... names) {
        return create(new Names(names));
    }

    public static Players create(Names names) {
        List<Player> players = names.values()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public int count() {
        return values.size();
    }

    public List<Player> values() {
        return Collections.unmodifiableList(values);
    }
}
