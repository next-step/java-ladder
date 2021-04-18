package laddergame.controller;

import laddergame.domain.ladder.*;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class LadderController {
    private static Player enrollOne(String name) {
        Name playerName = new Name(name);
        return new Player(playerName);
    }

    public static Players enroll(List<String> names) {
        return new Players(names.stream()
                .map(LadderController::enrollOne)
                .collect(toCollection(ArrayList::new)));
    }

    public static Ladder makeLadder(Size size, LadderStrategy strategy) {
        Ladder ladder = new Ladder(size);
        ladder.makeLink(strategy);
        return ladder;
    }

    public static Results makeResults(List<String> results) {
        return new Results(results.stream()
                .map(result -> new Result(result))
                .collect(toCollection(ArrayList::new)));
    }
}
