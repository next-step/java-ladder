package step4.dto;

import step4.domain.Prize;

public class PlayResultDto {
    private final Prize prize;

    public PlayResultDto(Prize prize) {
        this.prize = prize;
    }

    public Prize getPrize() {
        return prize;
    }
}
