package ladder.domain.nextstep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<NextStepLine> lines = new ArrayList<>();

    public void add(NextStepLine line){
        lines.add(line);
    }

    public List<NextStepLine> lines(){
        return Collections.unmodifiableList(lines);
    }
}
