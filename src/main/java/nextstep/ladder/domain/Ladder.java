package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {

    private static final int MIN_COUNT_OF_PERSON = 2;

    private final List<Name> playerNames;

    private final Lines lines;

    public Ladder(List<Name> playerNames, Lines lines) {

        if (playerNames.size() < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사다리 게임은 최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
        }

        this.playerNames = playerNames;
        this.lines = lines;
    }

    public static Ladder of(List<Name> playerNames, Lines lines) {
        return new Ladder(playerNames, lines);
    }

    public List<Line> lines() {
        return lines.values();
    }

    private int play(Name playerName) {
        boolean contains = playerNames.contains(playerName);
        if (!contains) {
            throw new IllegalArgumentException("참여자가 아닙니다.");
        }

        int position = playerNames.indexOf(playerName);

        return lines.finalPosition(position);
    }

    public LadderResult play() {
        Map<Name, Integer> ladderResultMap = playerNames.stream()
                .collect(Collectors.toMap(playerName -> playerName, this::play));

        return new LadderResult(ladderResultMap);
    }
}
