package ladder.service;

import ladder.domain.*;
import ladder.domain.code.Direction;
import ladder.domain.vo.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final Players players;
    private final Destinations destinations;
    private final Ladder ladder;

    public LadderGame(Players players,
                      Destinations destinations,
                      int height){
        this(players, destinations, createLadder(players, height));
    }

    public LadderGame(Players players,
                      Destinations destinations,
                      Ladder ladder) {
        this.players = players;
        this.destinations = destinations;
        this.ladder = ladder;
    }

    private static Ladder createLadder(Players players,
                                       int height){
        if(players.players().isEmpty()){
            throw new IllegalArgumentException("참가자는 필수 입니다.");
        }
        return new Ladder(players.count() - 1, height);
    }

    public Ladder ladder(){
        return ladder;
    }

    public Players players() {
        return players;
    }

    public Destinations destinations() {
        return destinations;
    }

    public Map<Player, Destination> wantedResults(Players players){
        return players.players().stream()
                .collect(Collectors.toMap(player -> player, this::playerResult));
    }

    private Destination playerResult(Player player) {
        for (int index = 0; index < ladder.height(); index++) {
            List<Row> rowList = ladder.rowsList().get(index).rows();
            player.move(decideDirection(rowList, player.position()));
        }
        return destinations.destinations().get(player.position());
    }

    private Direction decideDirection(List<Row> rowList, int position) {
        if (position < rowList.size() && rowList.get(position).bridgeExist()) {
            return Direction.RIGHT;
        }
        if (position > 0 && rowList.get(position - 1).bridgeExist()) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

}
