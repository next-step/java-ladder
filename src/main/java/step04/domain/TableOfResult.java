package step04.domain;

import java.util.List;
import java.util.Objects;

public class TableOfResult {
    private final List<Integer> tableOfResult;

    private TableOfResult(List<Integer> tableOfResult) {
        this.tableOfResult = tableOfResult;
    }

    public static TableOfResult of(List<Integer> tableOfResult) {
        return new TableOfResult(tableOfResult);
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
