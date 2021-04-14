package step4.dto;

import java.util.List;

import step4.domain.Prize;

public class PrizesDto {
    private final List<Prize> prizes;

    public PrizesDto(List<Prize> prizes){
        this.prizes = prizes;
    }
    public List<Prize> getPrizes() {
        return this.prizes;
    }
}
