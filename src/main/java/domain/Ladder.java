package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final int height;
    private final List<Line> lines;

    public Ladder(List<Name> names, int height) {
        this.height = height;
        this.lines = names.stream()
                .map(name -> new Line(name, height))
                .collect(Collectors.toList());
    }
}
