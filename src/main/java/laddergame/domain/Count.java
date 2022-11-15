package laddergame.domain;

import java.util.Objects;

public class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public boolean bigger(Count count) {
        return this.count > count.count;
    }

    public void plus() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "Count{" +
                "count=" + count +
                '}';
    }
}
