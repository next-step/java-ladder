package ladder.domain;

import java.util.List;
import ladder.domain.line.Line;
import ladder.domain.line.Lines;

public class Ladder {

    private final Lines lines;
    private final Users users;

    public Ladder(List<String> names, int height) {
        this.users = new Users(names);
        this.lines = new Lines(height);
    }

    public void addLines(List<Line> lines) {
        this.lines.addLines(lines);
    }

    public Line getLine(int index) {
        return this.lines.getLine(index);
    }

    public List<Line> getLines() {
        return this.lines.getLines();
    }

    public int getHeight() {
        return this.lines.getHeight();
    }

    public List<String> getNames() {
        return this.users.getNames();
    }

    public int getMaxNameLength() {
        return this.users.getMaxNameLength();
    }

    public int getCountOfPerson() {
        return this.users.getCountOfPerson();
    }

    public int getEndPoint(String name) {
        int currentPoint = this.users.getIndex(name);

        for(Line line : getLines()) {
            currentPoint += line.move(currentPoint);
        }

        return currentPoint;
    }
}
