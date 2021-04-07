package nextstep.ladder.dto;

public class LadderBoardDto {

    private final LadderDto ladderDto;
    private final RewardsDto rewardsDto;

    public LadderBoardDto(LadderDto ladderDto, RewardsDto rewardsDto) {
        this.ladderDto = ladderDto;
        this.rewardsDto = rewardsDto;
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public RewardsDto getRewardsDto() {
        return rewardsDto;
    }
}
