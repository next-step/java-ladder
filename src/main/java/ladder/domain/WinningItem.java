package ladder.domain;

import ladder.exception.WinningItemException;

import java.util.Objects;

public class WinningItem {
    private final String item;

    public WinningItem(String item) {
        validateItem(item);
        this.item = item;
    }

    private void validateItem(String item) {
        if (item == null || item.isEmpty()) {
            throw new WinningItemException(item);
        }
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningItem that = (WinningItem) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
