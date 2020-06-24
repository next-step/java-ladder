package ladder.domain.ladder;

import ladder.domain.play.Item;
import ladder.domain.play.Playing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Playing playing;
    private final Ladder ladder;

    private Game(Playing playing, int height) {
        this.playing = playing;
        this.ladder = Ladder.of(height, playing.getCountOfPlayers());
    }

    public static Game play(Playing playing, int height) {
        return new Game(playing, height);
    }

    public Map<Item, Item> makeResult(List<Integer> indexes) {
        Map<Item, Item> results = new HashMap<>();
        for (Integer index : indexes) {
            Item player = playing.getPlayersBy(index);
            Item result = playing.getResultsBy(ladder.makeResult(index));
            results.put(player, result);
        }

        return results;
    }

    @Override
    public String toString() {
        return this.playing.getPlayers().toString() +
                "\n" +
                this.ladder.toString() +
                "\n" +
                this.playing.getPrizes().toString();
    }
}
