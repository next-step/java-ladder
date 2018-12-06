package net.chandol.ladder.v2.dto;

import net.chandol.ladder.v2.domain.player.Player;
import net.chandol.ladder.v2.domain.prize.Prize;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class LadderGameResult {
    private Map<Player, Prize> resultMap = new HashMap<>();

    public void add(Player player, Prize prize) {
        resultMap.put(player, prize);
    }

    public Prize findPrize(String name) {
        return resultMap.get(new Player(name));
    }

    public String resultAllPrettyPrint() {
        return resultMap.entrySet().stream()
                .map(s -> s.getKey().getName() + ":" + s.getValue().getValue())
                .collect(joining("\n"));
    }
}
