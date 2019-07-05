package ladderGame.util;

import ladderGame.domain.Direction;

import java.util.List;

public interface DirectionGenerator {

    List<Direction> generate(int count);
}
