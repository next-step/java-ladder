package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String DELIMITER = ",";
    private final List<String> results;

    public GameResult(String results) {
        this.results = Arrays.stream(results.split(DELIMITER)).collect(Collectors.toUnmodifiableList());
    }

    public List<String> getResults() {
        return results;
    }

    public boolean validateGameResultCount(Gamers gamers) {
        if (gamers.getCountOfPerson() != results.size()) {
            throw new IllegalArgumentException("게임 결과와 참여자 인원 수가 다릅니다.");
        }
        return true;
    }
}
