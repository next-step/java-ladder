package rick.strategy;

import rick.domain.Points;

@FunctionalInterface
public interface LineCreationStrategy {

    Points create(int countOfPerson);
}
