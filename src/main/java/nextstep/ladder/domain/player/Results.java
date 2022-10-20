package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.player.Players.MAX_PLAYER_SIZE;
import static nextstep.ladder.domain.player.Players.MIN_PLAYER_SIZE;

public class Results {
    private static final String SIZE_EXCEPTION_MESSAGE = "결과는 " + MIN_PLAYER_SIZE + "개 이상 " + MAX_PLAYER_SIZE + "개 이하만 가능합니다." ;

    private final List<Result> values;

    public Results(String ... results) {
        checkSize(results);

        this.values = Stream.of(results)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private static void checkSize(String[] results) {
        if (results.length < MIN_PLAYER_SIZE ||
            results.length > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    public List<Result> values() {
        return Collections.unmodifiableList(values);
    }

    public int size() {
        return values.size();
    }

    public Result find(int index) {
        return values.get(index);
    }
}
