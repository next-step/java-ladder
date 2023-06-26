package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<Boolean>();
    private String INIT_SHAPE = "";
    private final String TRUE_SHAPE = "-----|";
    private final String FALSE_SHAPE = "     |";
    private final Random random = new Random();
    public Line(int width) {
        IntStream.range(0, width)
                .forEach(this::randomBoolean);
        makeLine();
    }
    private void randomBoolean(int index) {
        if(index == 0 || points.get(index - 1)) {
            points.add(false);
        } else {
            points.add(random.nextBoolean());
        }
    }

    private void makeLine() {
        points.forEach(this::buildShape);
    }

    private void buildShape(Boolean isX) {
        if(isX) {
            INIT_SHAPE = INIT_SHAPE + TRUE_SHAPE;
            return;
        }
        INIT_SHAPE = INIT_SHAPE + FALSE_SHAPE;
    }

    public String getShape() {
        return INIT_SHAPE;
    }

}
