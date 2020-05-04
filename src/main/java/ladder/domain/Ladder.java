package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int LINE_COUNT_MIN = 1;

    private List<Line> lines;

    private Ladder(List<Line> lines) {
    }

    public static Ladder getInstance(int height, int width) {
        if (height < LINE_COUNT_MIN) {
            throw new InvalidLadderHeightException();
        }

//        DirectionGenerator directionGenerator = new DefaultDirectionGenerator();
//        List<Line> lines = new ArrayList<>();
//        for (int i = 0; i < height; i++) {
//            lines.add(Line.init(width, directionGenerator));
//        }

        return new Ladder(Arrays.asList(Line.init(width)));
    }

    public static Ladder getInstance(List<Line> lines) {
        return new Ladder(lines);
    }


    public boolean isHeightSame(int height) {
        return height == lines.size();
    }

}
