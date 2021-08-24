package ladder.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.engine.Line;
import ladder.domain.engine.LineCreator;
import ladder.domain.engine.PointCreator;

public class MyLineCreator implements LineCreator {

    private final PointCreator pointCreator;

    public MyLineCreator(PointCreator pointCreator) {
        this.pointCreator = pointCreator;
    }

    @Override
    public Line create(int countOfPeople) {
        List<Tile> tiles = new ArrayList<>();
        Tile tile = Tile.first(pointCreator.create());
        tiles.add(tile);
        while (tiles.size() < countOfPeople - 1) {
            tile = tile.next(pointCreator.create());
            tiles.add(tile);
        }
        tile = tile.last();
        tiles.add(tile);
        return MyLine.of(tiles);
    }
}
