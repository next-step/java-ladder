package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.ResultDto;
import nextstep.ladder.domain.endpoint.Endpoints;
import nextstep.ladder.domain.exception.LadderGameInitializeException;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.strategy.DirectionRandomStrategy;

import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

public class LadderGame {
    public static final String DELIMITER_WORD = "쉼표";
    public static final String DELIMITER_MARK = ",";

    private final Players players;
    private final Ladder ladder;
    private final Endpoints endpoints;

    private LadderGame(final Ladder ladder, final Players players, final Endpoints endpoints) {
        this.players = players;
        this.ladder = ladder;
        this.endpoints = endpoints;
    }

    public static LadderGame initialize(final Players players, final int ladderHeight, final Endpoints endpoints) {
        verifyLadderGameInitialize(players, endpoints);
        final LadderSize ladderSize = LadderSize.of(players.size(), ladderHeight);
        final LadderGameContext ladderGameContext = LadderGameContext.of(ladderSize, DirectionRandomStrategy.getInstance());
        return new LadderGame(Ladder.from(ladderGameContext), players, endpoints);
    }

    private static void verifyLadderGameInitialize(final Players players, final Endpoints endpoints) {
        if (isEqSize(players, endpoints)) {
            throw new LadderGameInitializeException("참가자수와 결과개수가 다릅니다.");
        }
    }

    private static boolean isEqSize(final Players players, final Endpoints endpoints) {
        return Objects.requireNonNull(players).size() != Objects.requireNonNull(endpoints).size();
    }

    public ResultDto getGameResult() {
        players.ride(ladder);
        return ResultDto.of(playerInfos(), ladder.rowInfos(), endpoints.arriveAt());
    }

    private Map<String, Integer> playerInfos() {
        final List<String> names = players.names();
        final List<Integer> positions = players.positions();
        return range(0, names.size())
                .boxed()
                .collect(collectingAndThen(collectLinkedHashMap(names, positions), Collections::unmodifiableMap));
    }

    private Collector<Integer, ?, LinkedHashMap<String, Integer>> collectLinkedHashMap(final List<String> keys, final List<Integer> values) {
        return toMap(keys::get, values::get, (x, y) -> y, LinkedHashMap::new);
    }
}
