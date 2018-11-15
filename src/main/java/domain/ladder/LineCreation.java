package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineCreation{

    public List<Line> getLines(int ladderCount, int playerCount) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < ladderCount; i++){
            lines.add(new Line(new RandomPoint().getRandomPoint(playerCount)));
        }
        return lines;
    }

}
