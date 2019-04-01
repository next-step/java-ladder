package generator.ladder;

import domain.ladder.Ladders;

public interface LaddersGenerator {
    Ladders generate(int height, int size);
}
