package ladderWithInterface.engin;

import ladderWithInterface.custom.Direction;

import java.util.List;

public interface Line {

    int move(int position);

    List<Direction> draw();
}
