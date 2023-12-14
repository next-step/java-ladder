package ladderWithInterface.custom;

import ladderWithInterface.engin.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CustomLadderCreator implements LadderCreator {

    private LineCreator lineCreator;

    public CustomLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int countOfPosition, int height, CoordinateGenerator coordinateGeneration) {
        List<Line> lineList = Stream
                .generate(() -> lineCreator.create(countOfPosition, coordinateGeneration))
                .limit(height)
                .collect(toList());
        return new CustomLadder(lineList, countOfPosition);
    }
}
