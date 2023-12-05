package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int maxHeight, Players members){
        lines = IntStream.rangeClosed(1, maxHeight)
                .mapToObj(i -> new Line(members.membersCount()))
                .collect(Collectors.toList());
    }

    public List<Line> getLines(){
        return lines;
    }
}
