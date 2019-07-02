package com.ladder.model;

import java.util.Map;
import java.util.stream.Collectors;

public class PlayReport {

    private Map<Player, Reward> playResult;

    private PlayReport(Map<Player, Reward> playResult) {
        this.playResult = playResult;
    }

    static PlayReport of(Map<Player, Reward> playingResults) {
        return new PlayReport(playingResults);
    }

    public String searchByName(String playerName) {
        Player searchPlayer = playResult.keySet()
                .stream()
                .filter(player -> player.isMatch(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));

        return playResult.get(searchPlayer).getReward();
    }

    public Map<String, String> searchByAll() {
        return playResult.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        player -> player.getKey().getName(),
                        reward -> reward.getValue().getReward())
                );
    }
}
