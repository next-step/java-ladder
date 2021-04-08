package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public void add(Line line){
        lines.add(line);
    }

    public List<Line> lines(){
        return Collections.unmodifiableList(lines);
    }
}
