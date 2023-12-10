package nextstep.ladder.domain;

import nextstep.ladder.Lines;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {

    private static final int MIN_COUNT_OF_PERSON = 2;

    private final List<String> playerNames;

    private final List<String> result;

    private final Lines lines;

    public Ladder(List<String> playerNames, Lines lines, List<String> result) {
        if (playerNames.size() != result.size()) {
            throw new IllegalArgumentException("플레이어와 결과의 수는 동일해야 합니다.");
        }

        if (playerNames.size() < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사다리 게임은 최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
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

    public List<String> result() {
        return new ArrayList<>(result);
    }

    private String play(String playerName) {
        boolean contains = playerNames.contains(playerName);
        if (!contains) {
            throw new IllegalArgumentException("참여자가 아닙니다.");
        }

        int position = playerNames.indexOf(playerName);

        return result.get(lines.finalPosition(position));
    }

    public LadderResult play() {
        Map<String, String> ladderResultMap = playerNames.stream()
                .collect(Collectors.toMap(playerName -> playerName, this::play));

        return new LadderResult(ladderResultMap);
    }
}
