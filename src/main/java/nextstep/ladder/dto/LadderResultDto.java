package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final List<Player> players;
    private final List<Line> lines;

    public LadderResultDto(List<Player> players, List<Line> lines) {
        this.players = Collections.unmodifiableList(players);
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Line> getLines() {
        return this.lines;
    }

}
