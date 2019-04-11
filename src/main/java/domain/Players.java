package domain;

import util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String TAB_SIZE = "     ";
    private static final int MIN_PLAYER = 2;
    private List<Player> players = new ArrayList<>();

    public Players(List<String> players) {
        if (players.size() < MIN_PLAYER) {
            throw new IllegalArgumentException(ErrorMessage.NONE_PLAYER.getErrorMessage());
        }
        this.createPlayers(players);
    }

    private void createPlayers(List<String> players) {
        players.forEach(player -> this.players.add(new Player(player)));
    }

    public int countOfPerson() {
        return this.players.size();
    }

    public int calcPlayerPoint(String playerName) {
        int playerPoint = 0;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).toString().equals(playerName)) {
                playerPoint = i;
            }
        }
        return playerPoint;
    }

    @Override
    public String toString() {
        return String.join(
                TAB_SIZE,
                this.players
                        .stream()
                        .map(Player::toString)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object obj) {
        String playerName = new Player(obj.toString()).toString();
        return this.players
                .stream()
                .anyMatch(player -> player.toString().equals(playerName));
    }
}
