package nextstep.ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {

    public final static String SHOW_ALL_RESULT_KEY = "all";
    public static final String All_RESULT_DELIMITER = " : ";
    public static final String LINE_BREAK = "\n";
    public static final String PLAYER_NAME_NOT_EXIST_MESSAGE = "해당되는 이름을 가진 플레이어가 없습니다.";

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

    public String getPrizeNamesByName(String playerName) {

        if (SHOW_ALL_RESULT_KEY.equals(playerName)) {
            return concatAllGameResult();
        }

        return ladderGameResult.getOrDefault(playerName, PLAYER_NAME_NOT_EXIST_MESSAGE);
    }

    private String concatAllGameResult() {
        return ladderGameResult.entrySet().stream()
            .map((entry) -> entry.getKey() + All_RESULT_DELIMITER + entry.getValue())
            .collect(Collectors.joining(LINE_BREAK));
    }
}
