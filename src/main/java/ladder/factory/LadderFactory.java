package ladder.factory;

import ladder.domain.ConnectingStrategy;
import ladder.domain.second.LadderGame;
import ladder.domain.second.LadderLine;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static LadderCreator create(int maxLadderHeight, int countOfPlayers, ConnectingStrategy connectingStrategy) {
        List<LineCreator> lineCreators = new ArrayList<>();
        for (int i = 0; i < maxLadderHeight; i++) {
             lineCreators.add(new LadderLine(countOfPlayers - 1));
        }
        return new LadderGame(lineCreators, connectingStrategy);
    }
}