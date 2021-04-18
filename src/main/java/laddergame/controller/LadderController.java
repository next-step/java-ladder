package laddergame.controller;

import laddergame.domain.ladder.*;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;
import static laddergame.util.StringUtils.isAll;

public class LadderController {
    private static final int MATCH_ALL = -1;

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

    public static LadderStatistics statistics(Ladder ladder, Results results) {
        return new LadderStatistics(ladder, results);
    }

    public static int matchPlayer(Players players, String name) {
        if (isAll(name)) {
            return MATCH_ALL;
        }
        return players.whoseName(new Name(name));
    }

}
