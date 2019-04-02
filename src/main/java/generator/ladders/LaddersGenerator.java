package generator.ladders;

import domain.ladder.Ladders;

public interface LaddersGenerator {
    Ladders generate(int height, int lineSize);
}
