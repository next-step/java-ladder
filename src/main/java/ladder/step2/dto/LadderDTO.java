package ladder.step2.dto;

import ladder.step2.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderDTO {
    private final List<List<Boolean>> ladder;
    
    public LadderDTO(final Ladder ladder) {
        this.ladder = ladder.getLadder().stream()
                .map(Line::getLine)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }
    
    private List<Boolean> parseLine(final List<Point> points) {
        return points.stream()
                .map(Point::getDirection)
                .map(Direction::isLeft)
                .collect(Collectors.toList());
    }
    
    public List<List<Boolean>> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
