package step4_ladderGame.domain;

import step4_ladderGame.dto.PrizesDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Prizes {

    private final List<Prize> prizeList;

    private Prizes(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public static Prizes of(String[] prizeList, int playerCount) {
        valid(prizeList, playerCount);
        return Arrays.stream((prizeList))
                .map(Prize::of)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void valid(String[] prizeList, int playerCount) {
        if (prizeList.length != playerCount) {
            throw new IllegalArgumentException("상품의 수와 플레이어 수는 같아야 합니다.");
        }
    }

    public PrizesDto toDto() {
        return prizeList.stream()
                .map(Prize::toString)
                .collect(collectingAndThen(toList(), PrizesDto::new));
    }

    private String getPrizeName(int index) {
        return prizeList.get(index).toString();
    }

    public Map<String, String> match(Players playerList) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            result.put(playerList.isPlayerPosition(Position.of(i)), getPrizeName(i));
        }
        return result;
    }
}
