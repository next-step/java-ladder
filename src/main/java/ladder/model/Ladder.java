package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(int sizeOfPerson, int height, DirectionGenerator directionGenerator) {
        this.height = new Height(height);
        create(sizeOfPerson, directionGenerator);
    }

    private void create(int sizeOfPerson, DirectionGenerator directionGenerator) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(sizeOfPerson, directionGenerator));
        }
    }

    public GameResult play(Users users, Results results) {
        GameResult result = new GameResult();
        for (int i = 0; i < users.size(); i++) {
            result.put(users.findByIndex(i), results.findByIndex(getTarget(i)));
        }
        return result;
    }

    private int getTarget(int position) {
        int target = position;
        for (Line line : lines) {
            target = line.move(target);
        }
        return target;
    }

    public List<Line> getLines() {
        return lines;
    }
}
