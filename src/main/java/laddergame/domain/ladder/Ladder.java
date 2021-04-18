/*
 * 사다리를 담당하는 클래스
 * */
package laddergame.domain.ladder;

import laddergame.domain.ladder.line.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(Size size) {
        size.heightRange()
                .forEach(i -> lines.add(new Line(size)));
    }

    /* 테스트용 생성자 */
    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public void makeLink(LadderStrategy strategy) {
        lines.forEach(line -> line.connect(strategy));
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.moveOne(index);
        }
        return index;
    }
}
