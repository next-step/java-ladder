package ladder.dto;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.Rewards;

public class LadderGameResultDto {

    private final LadderLines ladderLines;
    private final Rewards rewards;

    public LadderGameResultDto(Rewards rewards, LadderLines ladderLines) {
        this.ladderLines = ladderLines;
        this.rewards = rewards;
    }

    public LadderLines ladderLines() {
        return ladderLines;
    }

    public Rewards results() {
        return rewards;
    }
}
