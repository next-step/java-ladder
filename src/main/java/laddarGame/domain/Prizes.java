package laddarGame.domain;

import laddarGame.dto.PrizesDto;
import laddarGame.exception.PrizeAndPlayerNotSameCountException;
import laddarGame.util.Parser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Prizes {

    private final List<Prize> prizeList;

    public Prizes(String prizeList) {
        this.prizeList = Arrays.stream(Parser.nameParser(prizeList))
                .map(Prize::new)
                .collect(toList());
    }

    public Map<String, String> match(List<String> playerList) {
        valid(playerList);
        Iterator<String> players = playerList.iterator();
        return prizeList.stream().map(Prize::getPrize).collect(toMap(prize -> players.next(), prize -> prize));
    }

    private void valid(List<String> playerList) {
        if (prizeList.size() != playerList.size()) {
            throw new PrizeAndPlayerNotSameCountException("플레이어 수와 상품 수가 같아야 합니다.");
        }
    }

    public PrizesDto toDto() {
        return new PrizesDto(prizeList);
    }
}
