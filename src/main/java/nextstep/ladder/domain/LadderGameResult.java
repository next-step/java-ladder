package nextstep.ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {

    public final static String SHOW_ALL_RESULT_KEY = "all";

    private final Map<String, String> ladderGameResult;

    private LadderGameResult(Map<String, String> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public static LadderGameResult from(Players players, LadderGamePrizes ladderGamePrizes) {
        System.out.println(ladderGamePrizes.toString());

        Map<String, String> ladderGameResult = IntStream.range(0, players.count())
            .boxed()
            .collect(Collectors.toUnmodifiableMap(
                players::getPlayerNameAt,
                ladderGamePrizes::getPrizeNameAt));

        return new LadderGameResult(ladderGameResult);
    }

    public Map<String, String> getLadderGameResult() {
        return ladderGameResult;
    }
}
