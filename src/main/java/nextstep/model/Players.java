package nextstep.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        this.players = new ArrayList<>();
        for (String name : names) {
            this.players.add(new Player(name));
        }
    }
    public String spacedNames() {
        return this.players.stream()
                .map(p -> p.player())
                .collect(Collectors.joining(EMPTY_LADDER_STRING,"",""));
    }

    public int filterResultIndex(Player player) {
        OptionalInt indexOpt = IntStream.range(0, this.players.size())
                .filter(i -> player.equals(this.players.get(i)))
                .findFirst();
        return indexOpt.getAsInt();
    }

    public Player filter(String name) {
        Player player = this.players.stream()
                .filter(p -> p.player().equals(name))
                .findFirst()
                .get();

        return player;
    }

    public List<Player> players() {
        return this.players;
    }

    public int size() {
        return this.players.size();
    }
}
