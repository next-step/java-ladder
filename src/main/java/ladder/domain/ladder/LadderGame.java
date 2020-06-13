package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<Integer> findAllPosition(int countOfPerson) {
        List<Integer> result = new ArrayList<>();
        for (int player = 0; player < countOfPerson; player++) {
            result.add(findResultPosition(player));
        }
        return result;
    }

    public int findResultPosition(int playerPosition) {
        for (int lineNumber = 0; lineNumber < ladder.height(); lineNumber++) {
            playerPosition = getNextPosition(ladder.get(lineNumber), playerPosition);
        }
        return playerPosition;
    }

    private int getNextPosition(Line line, int playerPosition) {
        if (hasLine(line.get(playerPosition))) {
            return playerPosition + 1;
        }
        if (playerPosition > 0 && hasLine(line.get(playerPosition - 1))) {
            return playerPosition - 1;
        }
        return playerPosition;
    }

    private boolean hasLine(Point point) {
        return point.hasLine();
    }
}
