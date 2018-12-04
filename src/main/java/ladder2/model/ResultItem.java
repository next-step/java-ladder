package ladder2.model;

import java.util.Objects;

public class ResultItem {
    private String item;

    private ResultItem(String item) {
        this.item = item;
    }

    public static ResultItem from(String item) {
        return new ResultItem(item);
    }

    @Override
    public String toString() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultItem that = (ResultItem) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
