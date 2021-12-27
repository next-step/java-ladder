package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Ladder {
    private final Users users;
    private final Lines lines;

    public Ladder(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public static Ladder from(Users users, Height height) {
        return new Ladder(users, Lines.of(users, height));
    }


    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

    public Play toPlay(Results results) {
        Line line = this.lines.getLines().get(0);
        List<Position> positions = first(line);

        for (int i = 1; i < this.lines.getLines().size(); i++) {
            Line line1 = this.lines.getLines().get(i);
            positions = next(positions, line1);
        }

        return new Play(positions, results);
    }

    private List<Position> first(Line line) {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < line.getPoints().size(); i++) {
            Point point = line.getPoints().get(i);
            positions.add(new Position(i, point, users.getUsers().get(i)).move());
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
            result.add(Position.of(position, point).move());
        }

        return result.stream()
            .sorted(Comparator.comparing(Position::getIndex))
            .collect(Collectors.toList());
    }
}
