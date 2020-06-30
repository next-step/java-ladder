package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> lines;

    public Line(int size) {

        this(size, new MakeLineWithRandom());
    }

    public Line(int size, MakeLine makeLine){

        boolean beforeLine = false;
        for (int index = 0; index < size; index++) {
            Boolean line = makeLine.createLine(beforeLine);
            beforeLine = line;
            lines.add(line);
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }

}
