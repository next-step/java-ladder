package step04.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TableOfResult {
    private final List<Integer> tableOfResult;

    private TableOfResult(List<Integer> tableOfResult) {
        this.tableOfResult = tableOfResult;
    }

    public static TableOfResult of(List<Integer> tableOfResult) {
        return new TableOfResult(tableOfResult);
    }

    public TableOfResult swapIndex(int index) {
        TableOfResult newTable = TableOfResult.of(tableOfResult);
        int temp1 = newTable.tableOfResult.get(index);
        int temp2 = newTable.tableOfResult.get(index + 1);
        newTable.tableOfResult.set(index, temp2);
        newTable.tableOfResult.set(index + 1, temp1);
        return newTable;
    }

    public int size() {
        return tableOfResult.size();
    }

    public int indexOf(int target) {
        return tableOfResult.indexOf(target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableOfResult that = (TableOfResult) o;
        return Objects.equals(tableOfResult, that.tableOfResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableOfResult);
    }

}
