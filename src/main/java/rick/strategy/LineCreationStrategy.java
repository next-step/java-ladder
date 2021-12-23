package rick.strategy;

import java.util.List;
import rick.domain.Point;

@FunctionalInterface
public interface LineCreationStrategy {

    List<Point> create(int countOfPerson);
}
