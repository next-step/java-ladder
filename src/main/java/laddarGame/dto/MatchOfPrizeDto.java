package laddarGame.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchOfPrizeDto {

    private final List<String> playerList;
    private final List<String> prizeList;

    private MatchOfPrizeDto(Map<String, String> resultPrizeResult) {
        this.playerList = new ArrayList<>(resultPrizeResult.keySet());
        this.prizeList = new ArrayList<>(resultPrizeResult.values());
    }

    private MatchOfPrizeDto(String player, String prize) {
        this.playerList = List.of(player);
        this.prizeList = List.of(prize);
    }

    public static MatchOfPrizeDto of(Map<String, String> resultPrizeResult) {
        return new MatchOfPrizeDto(resultPrizeResult);
    }

    public static MatchOfPrizeDto of(String player, String prize) {
        return new MatchOfPrizeDto(player, prize);
    }

    public List<String> getPlayerList() {
        return playerList;
    }

    public List<String> getPrizeList() {
        return prizeList;
    }
}
