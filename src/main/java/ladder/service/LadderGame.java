package ladder.service;

import ladder.domain.*;
import ladder.domain.code.Direction;
import ladder.domain.vo.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    public Map<Player, Destination> wantedResults(Ladder ladder, Players wantedPlayers){
        return wantedPlayers.players().stream()
                .collect(Collectors.toMap(player -> player, player -> playerResult(ladder, player)));
    }

    private Destination playerResult(Ladder ladder, Player player) {
        for (int index = 0; index < ladder.ladderBody().height(); index++) {
            List<Row> rowList = ladder.ladderBody().rowsList().get(index).rows();
            player.move(decideDirection(rowList, player.position()));
        }
        return ladder.destinations().destinations().get(player.position());
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
