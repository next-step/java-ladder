package nextstep.ladder.engine;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public interface GameResult {
    Optional<Prize> result(String playerName);

    Stream<Map.Entry<Name, Prize>> stream();
}
