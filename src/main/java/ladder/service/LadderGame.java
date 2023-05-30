package ladder.service;

import ladder.domain.*;

import java.util.stream.Collectors;

public class LadderGame {

    public PlayerResults makePlayResults(Players players, Ladder ladder, Results results) {
        return new PlayerResults(players.getPlayers()
                .stream()
                .map(playerName -> makePlayerResult(playerName, ladder, results))
                .collect(Collectors.toList()));
    }

    public PlayerResult makePlayerResult(Player player, Ladder ladder, Results results) {
        ladder.getLines()
                .stream()
                .forEach(line -> player.moveLocationInLine(line));
        return new PlayerResult(player, results.getResult(player.getLocation()));
    }
}
