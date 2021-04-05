package step4_ladderGame.dto;

import java.util.List;

public class PrizesDto {

    private final List<String> prizeList;

    public PrizesDto(List<String> prizeList) {
        this.prizeList = prizeList;
    }

    public List<String> getPrizeList() {
        return prizeList;
    }
}
