package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Column> columns;

    public Row(List<Column> columns) {
        this.columns = columns;
    }

    public static Row of(List<Boolean> line) {
        return new Row(lineToColumn(line));
    }

    private static List<Column> lineToColumn(List<Boolean> paths){
        return Stream.iterate(0, index -> index + 1)
                .limit(columnSize(paths))
                .map(index -> Column.of(leftPath(paths, index), rightPath(paths, index)))
                .collect(Collectors.toList());
    }

    private static int columnSize(List<Boolean> paths) {
        return paths.size() + 1;
    }

    private static Boolean leftPath(List<Boolean> columns, int index) {
        if(leftPathFirst(index)){
            return false;
        }

        return columns.get(index - 1);
    }

    /**
     * 첫번째 왼쪽 경로는 이동이 불가능하다.
     */
    private static boolean leftPathFirst(int index) {
        return index - 1 < 0;
    }

    /**
     * 마지막 오른쪽 경로는 이동이 불가능하다.
     */
    private static Boolean rightPath(List<Boolean> columns, int index) {
        if(rightPathLast(columns, index)){
            return false;
        }

        return columns.get(index);
    }

    private static boolean rightPathLast(List<Boolean> columns, int index) {
        return index >= columns.size();
    }

    public void navigate(Player player) {
        Column column = columns.get(player.position());
        column.navigate(player);
    }
}
