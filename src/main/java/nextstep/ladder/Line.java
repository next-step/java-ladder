package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private List<Boolean> points;
    private Random random = new Random();

    public Line (int countOfPerson) {
        this.points = Stream.iterate(random.nextBoolean(), this::hasLine)
                .limit(countOfPerson-1)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean b) {
        return b == true ? false : random.nextBoolean();
    }


}
