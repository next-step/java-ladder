package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<String> results;

    public GameResult(List<String> results) {
        this.results = results;
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

    public String getGameResultByPosition(int position) {
        return results.get(position);
    }
}
