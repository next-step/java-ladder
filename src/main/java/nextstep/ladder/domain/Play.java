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

    public Play(Ladder ladder) {
        this.positions = createBy(ladder);
    }

    public Position getPosition(int userPosition) {
        return positions.get(userPosition);
    }

    private List<Position> createBy(Ladder ladder) {
        Lines lines = ladder.getLines();
        int height = lines.height();
        List<Position> positions = first(lines.getFirstLine());

        for (int i = 1; i < height; i++) {
            Line line = lines.move(i);
            positions = next(positions, line);
        }
        return positions;
    }

    private List<Position> first(Line line) {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < line.width(); i++) {
            positions.add(new Position(i, (line.move(i))));
        }

        return positions.stream()
            .sorted(Comparator.comparing(Position::getEndPoint))
            .collect(Collectors.toList());
    }

    private List<Position> next(List<Position> positions, Line line) {
        List<Position> result = new ArrayList<>();

        for (int i = 0; i < line.width(); i++) {
            Position position = positions.get(i);
            result.add(Position.of(position).move(line.move(i)));
        }

        return result.stream()
            .sorted(Comparator.comparing(Position::getEndPoint))
            .collect(Collectors.toList());
    }
}
