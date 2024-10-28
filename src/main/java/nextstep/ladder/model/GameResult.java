package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String DELIMITER = ",";
    private final List<String> results;

    public GameResult(String results) {
        validateGameResult(results);
        this.results = Arrays.stream(results.split(DELIMITER)).map(String::trim).collect(Collectors.toUnmodifiableList());
    }

    public boolean validateGameResultCount(Gamers gamers) {
        if (gamers.getCountOfPerson() != results.size()) {
            throw new IllegalArgumentException("게임 결과와 참여자 인원 수가 다릅니다.");
        }
        return true;
    }

    public List<String> getResults() {
        return results;
    }

    private void validateGameResult(String results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("결과 문자열이 비어있거나 null입니다.");
        }
    }

    public String getGameResultByPosition(int position) {
        return results.get(position);
    }
}
