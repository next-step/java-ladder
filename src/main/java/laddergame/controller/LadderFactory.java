package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderStrategy;
import laddergame.domain.ladder.RandomLadderStrategy;
import laddergame.domain.ladder.Size;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class LadderFactory {

    private static final LadderStrategy strategy = new RandomLadderStrategy();

    public static Player enrollOne(String name) {
        Name playerName = new Name(name);
        return new Player(playerName);
    }

    public static Players enroll(List<String> names) {
        return new Players(names.stream()
                .map(LadderFactory::enrollOne)
                .collect(toCollection(ArrayList::new)));
    }

    public static Ladder makeLadder(Size size) {
        return new Ladder(size);
    }

    public static LadderStrategy strategy() {
        return strategy;
    }
}
