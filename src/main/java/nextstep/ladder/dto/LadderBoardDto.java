package nextstep.ladder.dto;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.reward.Rewards;

public class LadderBoardDto {

    private final LadderDto ladderDto;
    private final RewardsDto rewardsDto;

    public LadderBoardDto(LadderDto ladderDto, RewardsDto rewardsDto) {
        this.ladderDto = ladderDto;
        this.rewardsDto = rewardsDto;
    }

    public static LadderBoardDto of(Ladder ladder, Rewards rewards) {
        return new LadderBoardDto(ladder.export(), rewards.export());
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public RewardsDto getRewardsDto() {
        return rewardsDto;
    }
}
