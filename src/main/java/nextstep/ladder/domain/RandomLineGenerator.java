package nextstep.ladder.domain;

import nextstep.ladder.exception.LineRowException;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    private static final int MIN_ROW_COUNT = 1;
    private static final int ROW_FIRST_INDEX = 0;

    @Override
    public Line generate(List<Boolean> row) {
        validateRow(row);
        List<Column> columns = new ArrayList<>();

        addHead(columns, row.get(ROW_FIRST_INDEX));
        addBody(columns, row);
        addTail(columns, row.get(row.size() - 1));

        return Line.from(columns);
    }

    private static void addHead(List<Column> columns, Boolean first) {
        columns.add(Column.head(first));
    }

    private static void addBody(List<Column> columns, List<Boolean> line) {
        for (int index = 1; index < line.size(); index++) {
            Column column = Column.body(line.get(index - 1), line.get(index));
            columns.add(column);
        }
    }

    private static void addTail(List<Column> columns, Boolean last) {
        columns.add(Column.tail(last));
    }

    @Override
    public void validateRow(List<Boolean> row) {
        if (row.size() < MIN_ROW_COUNT) {
            throw new LineRowException(row.size());
        }
    }
}
