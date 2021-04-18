package laddergame.controller;

import laddergame.domain.ladder.*;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static laddergame.util.StringUtils.isAll;

public class LadderController {
    private static final int MATCH_ALL = -1;
    private static LadderStatistics statistics;

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

    public static void statistics(Ladder ladder, Results results) {
        statistics = new LadderStatistics(ladder, results);
    }

    public static Map<Player, Result> matchPlayer(Players players, String name) {
        Map<Player, Result> result = new LinkedHashMap<>();

        if (isAll(name)) {
            List<Result> resultList = statistics.matchAll(players.getNumber());
            IntStream.range(0, players.getNumber())
                    .forEach(i -> result.put(players.getOne(i), resultList.get(i)));
            return result;
        }
        int index = players.whoseName(new Name(name));
        result.put(players.getOne(index), statistics.matchOne(index));
        return result;
    }

}
