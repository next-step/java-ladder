package nextstep.ladder.domain;

import nextstep.ladder.Lines;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final String PLAY_ALL = "all";

    private final List<String> playerNames;

    private final List<String> result;

    private final Lines lines;

    public Ladder(List<String> playerNames, Lines lines, List<String> result) {
        if (playerNames.size() != result.size()) {
            throw new IllegalArgumentException("플레이어와 결과의 수는 동일해야 합니다.");
        }

        this.playerNames = playerNames;
        this.lines = lines;
        this.result = result;
    }

    public static Ladder of(List<String> playerNames, Lines lines, List<String> result) {
        return new Ladder(playerNames, lines, result);
    }

    public List<Line> lines() {
        return lines.values();
    }

    private String result(String playerName) {
        int position = playerNames.indexOf(playerName);

        return result.get(lines.finalPosition(position));
    }

    public List<String> play(String playName) {
        if (!PLAY_ALL.equals(playName)) {
            return List.of(result(playName));
        }

        return playerNames.stream()
                .map(this::result)
                .collect(Collectors.toList());
    }
}
