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
    private final Results results;

    public Ladder(Users users, Lines lines, Results results) {
        this.users = users;
        this.lines = lines;
        this.results = results;
    }

    public static Ladder from(Users users, Height height, Results results) {
        return new Ladder(users, Lines.of(users, height), results);
    }

    public Results getResultsBy(User user) {
        if (user.isAll()) {
            return results;
        }
        return Results.of(results.getResultBy(users.getIndexBy(user)));
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }

    public List<Position> toPlay() {
        Line line = this.lines.getLines().get(0);
        List<Position> init = init(line);

        for (int i = 1; i < this.lines.getLines().size(); i++) {
            Line line1 = this.lines.getLines().get(i);
            init = next(init, line1);
        }

        return init;
    }

    private List<Position> init(Line line) {
        List<Position> init = new ArrayList<>();

        for (int i = 0; i < line.getPoints().size(); i++) {
            Point point = line.getPoints().get(i);
            Position position = new Position(i, point, users.getUsers().get(i));
            init.add(position.move());
        }
        List<Position> collect = init.stream().sorted(Comparator.comparing(Position::getIndex)).collect(Collectors.toList());
        return collect;
    }

    private List<Position> next(List<Position> positions, Line line) {
        List<Position> init = new ArrayList<>();

        for (int i = 0; i < line.getPoints().size(); i++) {
            Point point = line.getPoints().get(i);
            Position position1 = positions.get(i);
            Position position = new Position(position1.getIndex(), point, position1.getUser());
            init.add(position.move());
        }
        List<Position> collect = init.stream().sorted(Comparator.comparing(Position::getIndex)).collect(Collectors.toList());
        return collect;
    }
}
