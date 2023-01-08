package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(Members members, Height height){
        this(valueOf(members, height));
    }

    private Ladder(List<Line> lines){
        this.lines = lines;
    }
    private static List<Line> valueOf(Members members, Height height){
        return IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(members))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
