package ladderWithInterface.custom;

import ladderWithInterface.engin.CoordinateGenerator;
import ladderWithInterface.engin.Line;
import ladderWithInterface.engin.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class CustomLineCreator implements LineCreator {

    @Override
    public Line create(int sizeOfPerson, CoordinateGenerator coordinateGenerator) {
        Direction direction = Direction.first(coordinateGenerator.generate());
        List<Direction> list = new ArrayList<>();
        list.add(direction);

        for (int i = 1; i < sizeOfPerson - 1; i++) {
            direction = direction.next(coordinateGenerator.generate());
            list.add(direction);
        }
        list.add(direction.end());
        return new CustomLine(list);
    }
}
