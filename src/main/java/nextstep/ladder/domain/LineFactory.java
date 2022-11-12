package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private final RandomDirectionGenerator randomDirectionGenerator;

    public LineFactory(RandomDirectionGenerator randomDirectionGenerator) {
        this.randomDirectionGenerator = randomDirectionGenerator;
    }

    public Line generateRandomLine(int countOfUser) {
        List<Direction> directions = new ArrayList<>();
        Direction direction = Direction.first(randomDirectionGenerator.generate());

        directions.add(direction);
        for (int i = 1; i < countOfUser; i++) {
            if(i == countOfUser - 1) {
                directions.add(direction.last());
                break;
            }
            direction = direction.next(randomDirectionGenerator.generate());
            directions.add(direction);
        }

        return new Line(directions);
    }
}
