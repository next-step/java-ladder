package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;
import camp.nextstep.edu.nextstep8.ladder.entity.Point;
import camp.nextstep.edu.nextstep8.ladder.entity.Row;
import camp.nextstep.edu.nextstep8.ladder.entity.Rows;

import java.util.stream.Collectors;

public class LadderViewGenerator {
    private static final String PIPE = "|";
    private static final String LINE = "-----";
    private static final String SPACE = "     ";

    private final Ladder ladder;

    public LadderViewGenerator(Ladder ladder) {
        this.ladder = ladder;
    }

    public String getHeaderForPrint() {
        return ladder.getJoiners().getNames().stream()
                .collect(Collectors.joining(SPACE));
    }

    public String getLadderForPrint() {
        StringBuilder output = new StringBuilder();
        Rows rows = ladder.getRows();
        for(int rowNumber = 0; rowNumber < rows.count(); rowNumber++) {
            output.append(getRowForPrint(rows.get(rowNumber)));
            output.append("\n");
        }

        return output.toString();
    }

    private String getRowForPrint(Row row) {
        StringBuilder output = new StringBuilder();

        for(int col = 0; col < row.columnSize(); col++) {
            Point cur = row.pick(row.number(), col);
            Point next = row.pick(row.number(), col + 1);
            output.append(PIPE);
            output.append(resolveDrawLine(cur, next));
        }

        return output.toString();
    }

    private boolean hasDrawLine(Point cur, Point next) {
        return cur.isStart() && next.isEnd();
    }

    private String resolveDrawLine(Point cur, Point next) {
        return hasDrawLine(cur, next) ? LINE : SPACE;
    }
}
