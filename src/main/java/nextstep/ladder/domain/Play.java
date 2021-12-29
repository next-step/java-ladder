package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Play {
    private final List<Position> positions;

    public Play(Ladder ladder, Users users) {
        this.positions = createBy(ladder, users);
    }

    public List<Position> getPosition() {
        return positions;
    }

    private List<Position> createBy(Ladder ladder, Users users) {
        Lines lines = ladder.getLines();
        int size = lines.getLinesSize();
        List<Position> positions = first(lines.getFirstLine(), users);

        for (int i = 1; i < size; i++) {
            Line line = lines.getLineBy(i);
            positions = next(positions, line);
        }
        return positions;
    }

    private List<Position> first(Line line, Users users) {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < line.getPoints().size(); i++) {
            Point point = line.getPoints().get(i);
            positions.add(new Position(i, users.getUsers().get(i)).move(point));
        }

        return positions.stream()
            .sorted(Comparator.comparing(Position::getIndex))
            .collect(Collectors.toList());
    }

    private List<Position> next(List<Position> positions, Line line) {
        List<Position> result = new ArrayList<>();

        for (int i = 0; i < line.getPoints().size(); i++) {
            Point point = line.getPoints().get(i);
            Position position = positions.get(i);
            result.add(Position.of(position).move(point));
        }

        return result.stream()
            .sorted(Comparator.comparing(Position::getIndex))
            .collect(Collectors.toList());
    }
}
