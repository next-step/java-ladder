package my.project.dto;

import my.project.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        this.lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }
}
