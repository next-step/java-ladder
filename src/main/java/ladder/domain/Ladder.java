/*
* 사다리를 담당하는 클래스
* */
package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Size size) {
        size.heightRange()
                .forEach( i -> lines.add(new Line(size)));
    }
}
