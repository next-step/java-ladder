package ladder.domain.line;

import ladder.domain.common.Printable;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine implements Printable {

    public static final char LINE_CHAR = '|';
    public static final String BRIDGE_LINE = "-----";
    public static final String EMPTY_LINE = "     ";

    private final Line line;

    private LadderLine(Line line) {
        this.line = line;
    }

    public static LadderLine of(int countOfPoint, DrawStrategy drawStrategy) {
        Line line = new Line(countOfPoint);
        for (int i = 0; i < countOfPoint - 1; i++) {
            drawStrategy.draw(i, line::drawsFrom);
        }
        return new LadderLine(line);
    }

    public int move(int position) {
        return line.move(position);
    }

    public int countOfPoint() {
        return line.countOfPoint();
    }

    @Override
    public String print() {
        return IntStream.range(0, line.countOfPoint() - 1)
                .mapToObj(i -> LINE_CHAR + (line.startsWith(i) ? BRIDGE_LINE : EMPTY_LINE))
                .collect(Collectors.joining()) + LINE_CHAR;
    }
}
