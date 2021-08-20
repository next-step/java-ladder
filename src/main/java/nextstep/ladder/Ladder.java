package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class Ladder {

    private List<Boolean> lines = new ArrayList<>();
    private StringBuffer stringLine = new StringBuffer();
    private LineStrategy lineStrategy;
    int numberOfPlayer;


    public Ladder(int numberOfPlayer, LineStrategy lineStrategy) {
        this.numberOfPlayer = numberOfPlayer;
        this.lineStrategy = lineStrategy;
        initLadder();
        drawLadderLine();
    }

    public static Ladder of(int numberOfPlayer, LineStrategy lineStrategy) {
        return new Ladder(numberOfPlayer, lineStrategy);
    }


    private void initLadder() {
        lines.add(lineStrategy.lineAble());
        IntStream.range(NUMBER_ONE, this.numberOfPlayer)
                .forEach(idx -> createBooleanLine(idx));
    }


    private void createBooleanLine(int row) {
        if (lines.get(row - NUMBER_ONE)) {
            lines.add(false);
            return;
        }
        lines.add(true);
    }


    private void drawLadderLine() {
        for (int index = NUMBER_ZERO; index < numberOfPlayer; index++) {
            createStringLine(lines.get(index), index);
        }
    }

    private void createStringLine(boolean line, int index) {
        if (index == (numberOfPlayer - NUMBER_ONE)) {
            stringLine.append(FALSE_LINE);
            return;
        }

        if (line) {
            stringLine.append(TRUE_LINE);
            return;
        }
        stringLine.append(FALSE_LINE);
    }

    public StringBuffer getStringLine() {
        return stringLine;
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
