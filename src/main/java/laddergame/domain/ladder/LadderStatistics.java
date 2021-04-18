package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderStatistics {
    private final Ladder ladder;
    private final Results results;

    public LadderStatistics(Ladder ladder, Results results) {
        this.ladder = ladder;
        this.results = results;
    }

    public Map<Player, Result> matchOne(Players players, int index) {
        Map<Player, Result> result = new LinkedHashMap<>();
        int moveIndex = ladder.move(index);
        result.put(players.getOne(index), results.getOne(moveIndex));
        return result;
    }

    public Map<Player, Result> matchAll(Players players) {
        Map<Player, Result> result = new LinkedHashMap<>();
        List<Player> playerList = players.getPlayers();
        IntStream.range(0, playerList.size())
                .forEach(i -> {
                    result.put(playerList.get(i), results.getOne(ladder.move(i)));
                });
        return result;
    }


    //    public LadderStatistics(Ladder ladder, Players players) {
//        this.ladder = ladder;
//        this.players = players;
//    }
//
//    public Map<Player, Integer> result(Name name) {
//        Map<Player, Integer> results = new HashMap<>();
//        int startIndex = players.whoseName(name);
//        results.put(players.getOne(startIndex), ladder.move(startIndex));
//        return results;
//    }
//
//    public Map<Player, Integer> resultAll() {
//        Map<Player, Integer> results = new LinkedHashMap<>();
//        List<Player> playerList = players.getPlayers();
//        IntStream.range(0, playerList.size())
//                .forEach(i -> results.put(playerList.get(i), ladder.move(i)));
//
//        return results;
//    }


}
