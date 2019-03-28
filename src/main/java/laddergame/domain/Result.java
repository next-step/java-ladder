package laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;

import static laddergame.ApplicationLauncher.ALL;

public class Result {
    private static final String COLON = ":";

    private final List<String> lineResult;
    private final Map<EndPoint, EndPoint> gameResult;

    public Result(List<String> lineResult, Map<EndPoint, EndPoint> gameResult) {
        this.lineResult = lineResult;
        this.gameResult = gameResult;
    }

    public List<String> getLineResult() {
        return lineResult;
    }

    public List<String> getGameResult(String key) {
        if(ALL.equals(key)) {
            return getAllGameResult();
        }

        return getOneGameResult(key);
    }

    private List<String> getAllGameResult() {
        return gameResult
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().getName() + " " + COLON + " " + entry.getValue().getName())
                .collect(Collectors.toList());
    }

    private List<String> getOneGameResult(String key) {
        return new ArrayList<>(
                Collections.singleton(
                        Optional.ofNullable(gameResult.get(key))
                                .map(EndPoint::getName)
                                .orElse("없음")
                )
        );
    }
}
