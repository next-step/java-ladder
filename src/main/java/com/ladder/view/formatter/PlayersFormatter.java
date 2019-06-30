package com.ladder.view.formatter;

import com.ladder.model.Player;
import com.ladder.model.Players;

import java.util.stream.Collectors;

public class PlayersFormatter implements Formatter<Players> {

    private final Formatter<Player> playerFormatter = new PlayerFormatter();

    @Override
    public String format(Players players) {
        return players.getPlayers()
                .stream()
                .map(playerFormatter::format)
                .collect(Collectors.joining());
    }
}
