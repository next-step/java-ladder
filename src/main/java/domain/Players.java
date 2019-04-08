package domain;

import lombok.Getter;

import java.util.List;


public class Players {
    private List<Player> players;

    @Getter
    private int number;

    public Players(List<Player> list) {
        this.players = list;
        this.number = list.size();
    }

    @Override
    public String toString() {
        return players.toString() +
                "  ";
    }
}
