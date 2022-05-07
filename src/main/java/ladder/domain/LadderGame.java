package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final List<Line> ladder = new ArrayList<>();

    public LadderGame(int countOfParticipants, int heightOfLadder) {
        while (heightOfLadder > 0) {
            ladder.add(new Line(countOfParticipants));
            heightOfLadder--;
        }
    }

    public void start(GameResult result) {
        int countOfParticipants = result.getNumberOfResults();
        for (int i = 0; i < countOfParticipants; i++) {
            result.save(i, start(i));
        }
    }

    private int start(int indexOfParticipants) {
        int result = indexOfParticipants;
        for (int height = 0, heightOfLadder = ladder.size(); height < heightOfLadder; height++) {
            result += ladder.get(height).move(result);
        }
        return result;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    @Override
    public String toString() {
        return ladder.toString();
    }
}
