package ladder.domain;

import ladder.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final Players players;
    private final List<String> results = new ArrayList<>();

    public LadderResult(List<String> names, List<String> result) {
        if (names.size() != result.size()) {
            throw new IllegalArgumentException("입력한 결과 개수가 부족합니다.");
        }
        this.players = new Players(names);
        this.results.addAll(result);
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<String> getResults() {
        return results;
    }

    public List<ResultDto> results(Ladder ladder) {
        List<ResultDto> matchedResults = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            matchedResults.add(new ResultDto(players.get(i), result(i, ladder)));
        }
        return matchedResults;
    }

    public String result(String name, Ladder ladder) {
        return result(new Player(name), ladder);
    }

    private String result(Player player, Ladder ladder) {
        int playerIndex = this.players.index(player);
        return result(playerIndex, ladder);
    }

    private String result(int index, Ladder ladder) {
        int matchedIndex = ladder.index(index);
        return results.get(matchedIndex);
    }
}
