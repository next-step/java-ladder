package ladder_v2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    public GameResult play(Players players, Rewards rewards, Ladder ladder) {
        Map<String, String> result = new HashMap<>();

        for(int i = 0; i < ladder.pointCount(); i++){
            Position position = new Position(i);
            for(Line line: ladder.lines()){
                Direction direction =line.points().get(position.position()).move();
                position = position.move(direction);
            }
            result.put(players.get(i).name(), rewards.get(position.position()));
        }
        return new GameResult(result);
    }
}
