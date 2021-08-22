package ladder.domain;

import ladder.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {
    private final List<Player> players;
    private final List<String> results = new ArrayList<>();

    public LadderResult(List<String> names, List<String> result) {
        if (names.size() != result.size()) {
            throw new IllegalArgumentException("입력한 결과 개수가 부족합니다.");
        }
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.results.addAll(result);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getResults() {
        return results;
    }

    private int matchedIndex(Player player) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).equals(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 player를 찾을 수 없습니다."));
    }

    private String matchedResult(int index, Ladder ladder) {
        int matchedIndex = matchedPoint(index, ladder);
        return results.get(matchedIndex);
    }

    private String matchedResult(Player player, Ladder ladder) {
        int playerIndex = matchedIndex(player);
        return matchedResult(playerIndex, ladder);
    }

    public String matchedResult(String name, Ladder ladder) {
        return matchedResult(new Player(name), ladder);
    }

    public List<ResultDto> matchedAllResult(Ladder ladder) {
        List<ResultDto> matchedResults = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            matchedResults.add(new ResultDto(players.get(i), matchedResult(i, ladder)));
        }
        return matchedResults;
    }

    private int matchedPoint(int index, Ladder ladder) {
        int resultIndex = index;
        for (Line line : ladder.getLines()) {
            resultIndex = position(resultIndex, line);
        }
        return resultIndex;
    }

    private int position(int index, Line line) {
        if (index < line.size() && line.point(index)) {
            return index + 1;
        }
        if (index > 0 && line.point(index - 1)) {
            return index - 1;
        }
        return index;
    }
}
