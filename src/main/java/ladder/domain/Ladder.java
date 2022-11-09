package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Name> nameList = new ArrayList<>();
    private final List<Line> lines = new ArrayList<>();

    public Ladder(List<String> nameList, int height) {
        for (String name : nameList) {
            this.nameList.add(new Name(name));
        }

        for (int i = 0; i < height; i++) {
            lines.add(new Line(nameList.size()));
        }
    }

    public List<String> names() {
        return nameList.stream()
                .map(Name::name)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
