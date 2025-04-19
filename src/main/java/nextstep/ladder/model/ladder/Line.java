package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.DefaultRandomPointGenerator;
import nextstep.ladder.strategy.RandomPointGenerator;

public class Line {
    private final Points points;

    public Line(final Players players) {
        this(players, new DefaultRandomPointGenerator());
    }
    
    public Line(final Players players, final RandomPointGenerator pointGenerator) {
        this.points = Points.create(players, pointGenerator);
    }

    public boolean hasLine(final Position position) {
        return points.hasLine(position);
    }

    public Position movePosition(final Position position) {
        return determineNextPosition(position);
    }
    
    private Position determineNextPosition(final Position position) {
        if (position.getIndex() > 0 && hasLine(position.moveLeft())) {
            return position.moveLeft();
        }
        
        if (hasLine(position)) {
            return position.moveRight();
        }
        
        return position;
    }
} 
