package step4.domain;

import java.util.HashMap;
import java.util.Map;

import step4.dto.PlayResultDto;
import step4.dto.PlayResultsDto;

public class PlayResult {
    private final Map<Player, Prize> result;

    public PlayResult() {
        result = new HashMap<>();
    }

    public void addResult(Player player, Prize prize) {
        result.put(player, prize);
    }

    public Map<Player, Prize> getResult() {
        return result;
    }

    public Prize matchPlayer(Player matchPlayer) {
        return result.get(matchPlayer);
    }

    public PlayResultDto getMatchPlayer(Player player) {
        return new PlayResultDto(matchPlayer(player));
    }

    public PlayResultsDto getAllMatchPlayer() {
        return new PlayResultsDto(result);
    }
}
