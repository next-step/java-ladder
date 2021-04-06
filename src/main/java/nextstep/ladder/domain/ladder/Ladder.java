package nextstep.ladder.domain.ladder;

import nextstep.ladder.dto.Connections;
import nextstep.ladder.dto.LadderDto;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    static final int MINIMUM_HEIGHT = 1;
    static final int MINIMUM_WIDTH = 2;

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int passThrough(int position) {
        for (Line line : lines) {
            position = line.nextPosition(position);
        }

        return position;
    }

    public LadderDto export() {
        List<Connections> connectionsList = lines.stream()
                                                 .map(Line::exportConnections)
                                                 .collect(Collectors.toList());
        
        return new LadderDto(connectionsList);
    }

}
