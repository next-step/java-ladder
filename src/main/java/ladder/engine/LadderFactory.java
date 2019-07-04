package ladder.engine;

import ladder.engine.impl.DefaultLadder;
import ladder.engine.impl.LineFactory;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static Ladder createLadder(int sizeOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineFactory.createLine(sizeOfPerson));
        }
        return new DefaultLadder(sizeOfPerson, lines);
    }
}
