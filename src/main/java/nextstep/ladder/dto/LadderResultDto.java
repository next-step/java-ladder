package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final List<Player> players;
    private final List<Line> lines;
    private final List<String> results;

    public LadderResultDto(List<Player> players, List<Line> lines, List<String> results) {
        this.players = Collections.unmodifiableList(players);
        this.lines = Collections.unmodifiableList(lines);
        this.results = Collections.unmodifiableList(results);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<String> getResults() {
        return this.results;
    }
}
