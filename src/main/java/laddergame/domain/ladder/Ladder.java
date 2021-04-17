/*
 * 사다리를 담당하는 클래스
 * */
package laddergame.domain.ladder;

import laddergame.domain.ladder.line.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Size size) {
        size.heightRange()
                .forEach(i -> lines.add(new Line(size)));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }


    public void makeLink(LadderStrategy strategy) {
        lines.forEach(line -> line.connect(strategy));
    }
}
