package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;

import java.util.List;

public class LadderGame {
    private final int height;
    private final List<String> scores;
    private final Ladder ladder;

    public LadderGame(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        this.height = ladderRequestDto.getHeight();
        this.scores = ladderRequestDto.getResults();
        this.ladder = new Ladder(ladderRequestDto, bridgeGenerator);
    }

    public LadderResultDto getLadderResult() {
        return new LadderResultDto(this.ladder, this.scores);
    }

    public List<LadderGameResultDto> execute() {
        for (int i = 0 ; i < this.height; i++) {
            this.ladder.moveLine(i);
        }
        return this.ladder.getLadderGameResults(this.scores);
    }
}
