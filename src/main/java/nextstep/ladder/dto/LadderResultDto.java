package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Scores;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final List<Player> players;
    private final List<Line> lines;
    private final Scores scores;

    public LadderResultDto(List<Player> players, List<Line> lines, Scores scores) {
        this.players = Collections.unmodifiableList(players);
        this.lines = Collections.unmodifiableList(lines);
        this.scores = scores;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public Scores getScores() {
        return this.scores;
    }
}
