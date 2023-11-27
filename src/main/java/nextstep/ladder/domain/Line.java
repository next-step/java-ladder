package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> step;

    public Line(int participantCount) {
        int stepSpace = participantCount-1;
        step = new ArrayList<>(stepMaker(stepSpace));
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(step);
    }

    private List<Boolean> stepMaker(int stepSpace) {
        return Stream.iterate(new Random().nextBoolean(), previous -> previousCheck(previous))
                .limit(stepSpace)
                .collect(Collectors.toList());
    }

    private boolean previousCheck(boolean previous) {
        if (!previous) {
            return new Random().nextBoolean();
        }
        return false;
    }
}
