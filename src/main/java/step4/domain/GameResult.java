package step4.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private static final String NOT_FOUND_PARTICIPANT = "존재하지 않는 사용자입니다.";

    private final Map<String, String> gameResult;

    private GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult of(GameInfo gameInfo, Ladder ladder) {
        return new GameResult(toResult(gameInfo, ladder));
    }

    private static Map<String, String> toResult(GameInfo gameInfo, Ladder ladder) {
        List<String> participantNames = gameInfo.participantNames();
        List<String> rewardNames = ladder.startAll().stream()
                .map(position -> gameInfo.rewardName(position.position()))
                .collect(Collectors.toList());
        return IntStream.range(0, participantNames.size()).boxed()
                .collect(Collectors.toMap(participantNames::get, rewardNames::get));
    }

    public String result(String name) {
        if (!contains(name)) {
            return NOT_FOUND_PARTICIPANT;
        }
        return gameResult.get(name);
    }

    public Map<String, String> resultAll() {
        return gameResult;
    }

    private boolean contains(String name) {
        return gameResult.containsKey(name);
    }
}
