package ladder.domain;

import java.util.List;

@FunctionalInterface
public interface PointsGenerator {
    List<Boolean> generate(int countOfPerson);
}
