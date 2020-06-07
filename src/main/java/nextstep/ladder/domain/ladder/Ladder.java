package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ladder {
    private final Lines lines;
    private final Players players;

    public Ladder(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        this.lines = new Lines(ladderRequestDto, bridgeGenerator);
        this.players = new Players(ladderRequestDto.getNames());
    }

    public void moveLine(int height) {
        for (Player player : players.getPlayers()) {
            Player currentPlayer = this.players.findPlayer(player);
            Line line = lines.findLine(height);
            Position linePosition = line.move(currentPlayer.getCurrentLinePosition());
            currentPlayer.move(linePosition);
        }
    }

    public List<LadderGameResultDto> getLadderGameResults(List<String> scores) {
        List<LadderGameResultDto> ladderGameResultDtos = new ArrayList<>();
        for (Player player : this.players.getPlayers()) {
            String score = this.findScore(scores, player.getCurrentLinePosition());
            LadderGameResultDto ladderGameResultDto = new LadderGameResultDto(player.getName(), score);
            ladderGameResultDtos.add(ladderGameResultDto);
        }
        return ladderGameResultDtos;
    }

    private String findScore(List<String> scores, Position position) {
        return Optional.ofNullable(scores.get(position.getPosition()))
                .orElseThrow(() -> new IllegalArgumentException("not found score"));
    }

    public Lines getLines() {
        return this.lines;
    }

    public Players getPlayers() {
        return this.players;
    }
}
