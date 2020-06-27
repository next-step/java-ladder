package ladder.domain.ladder;

import ladder.domain.play.Item;
import ladder.domain.play.Playing;
import ladder.domain.result.Results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Playing playing;
    private final Ladder ladder;

    private Game(Playing playing, Height height) {
        this.playing = playing;
        this.ladder = Ladder.of(height, playing.getCountOfPlayers());
    }

    public static Game play(Playing playing, Height height) {
        return new Game(playing, height);
    }

    public Results makeResult(String targetPlayer) {
        List<Integer> indexes = playing.findPlayerIndexBy(targetPlayer);

        return makeResults(indexes);
    }

    private Results makeResults(List<Integer> indexes) {
        Map<Item, Item> results = new HashMap<>();

        for (Integer index : indexes) {
            Item player = playing.getPlayersBy(index);
            Item result = playing.getResultsBy(ladder.makeResult(index));
            results.put(player, result);
        }

        return Results.of(results);
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
