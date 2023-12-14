package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {

    private final LadderPlayers ladderPlayers;

    private final Lines lines;

    public Ladder(LadderPlayers ladderPlayers, Lines lines) {
        this.ladderPlayers = ladderPlayers;
        this.lines = lines;
    }

    public static Ladder of(LadderPlayers ladderPlayers, Lines lines) {
        return new Ladder(ladderPlayers, lines);
    }

    public List<Line> lines() {
        return lines.values();
    }

    private int play(Name playerName) {
        return lines.finalPosition(ladderPlayers.positionOfPlayer(playerName));
    }

    public LadderResult play() {
        Map<Name, Integer> ladderResultMap = ladderPlayers.values()
                .stream()
                .collect(Collectors.toMap(playerName -> playerName, this::play));

        return new LadderResult(ladderResultMap);
    }
}
