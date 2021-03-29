package laddarGame.dto;

import laddarGame.domain.Prize;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PrizesDto {

    private final List<String> prizeList;

    public PrizesDto(List<Prize> prizeList) {
        this.prizeList = prizeList.stream()
                .map(Prize::getPrize)
                .collect(toList());
    }

    public List<String> getPrizeList() {
        return prizeList;
    }
}
