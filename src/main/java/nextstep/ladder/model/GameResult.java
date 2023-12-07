package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<String> resultList;

    public GameResult(List<String> list) {
        this.resultList = list;
    }

    public static GameResult of(String origin) {
        List<String> splitOrigin = Arrays.stream(origin.replaceAll(" ", "").split(","))
            .collect(Collectors.toList());
        return new GameResult(splitOrigin);
    }

    public List<String> list() {
        return resultList;
    }
}
