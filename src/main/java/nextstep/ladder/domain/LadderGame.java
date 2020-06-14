package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final LadderLines ladderLines;
    private final Players players;
    private final Scores scores;

    public LadderGame(LadderRequestDto ladderRequestDto, MovementGenerator movementGenerator) {
        this.players = new Players(ladderRequestDto.getNames());
        int countOfPerson = ladderRequestDto.getNames().size();
        this.ladderLines = LadderLines.generateLines(countOfPerson, ladderRequestDto.getHeight(), movementGenerator);
        this.scores = new Scores(ladderRequestDto.getScores());
    }

    public LadderResultDto getLadderResult() {
        return new LadderResultDto(this.players.findAllPlayerNames(), this.ladderLines, this.scores.getScores());
    }

    public LadderGameResultDto findLadderGameResult(String playerName) {
        Player player = this.players.findPlayer(playerName);
        int moveIndex = this.ladderLines.move(player.getAssignBridgeIndex());
        return new LadderGameResultDto(playerName, this.scores.findScore(moveIndex));
    }

    public List<LadderGameResultDto> findAllLadderGameResult() {
        List<LadderGameResultDto> ladderGameResultDtos = new ArrayList<>();
        List<String> allPlayerNames = this.players.findAllPlayerNames();
        for (String playerName : allPlayerNames) {
            ladderGameResultDtos.add(this.findLadderGameResult(playerName));
        }
        return ladderGameResultDtos;
    }
}
