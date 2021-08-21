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
            lines.add(COMMON_FALSE);
            return;
        }
        lines.add(COMMON_TRUE);
    }

    public StringBuffer getStringLine() {
        return stringLine;
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
