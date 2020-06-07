package nextstep.ladder.dto;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {
    private final Players players;
    private final Lines lines;
    private final List<String> results;

    public LadderResultDto(Ladder ladder, List<String> results) {
        this.players = ladder.getPlayers();
        this.lines = ladder.getLines();
        this.results = Collections.unmodifiableList(results);
    }

    public Players getPlayers() {
        return this.players;
    }

    public Lines getLines() {
        return this.lines;
    }

    public List<String> getResults() {
        return this.results;
    }
}
