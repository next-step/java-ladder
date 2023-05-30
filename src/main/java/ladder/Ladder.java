package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;

    public Ladder(int height, int nameSize) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(nameSize))
                .collect(Collectors.toList());
    }

    public List<Line> getLines(){
        return lines;
    }

}
