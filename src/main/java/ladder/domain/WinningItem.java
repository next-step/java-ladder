package ladder.domain;

import ladder.exception.WinningItemException;

public class WinningItem {
    private final String item;

    public WinningItem(String item) {
        validateItem(item);
        this.item = item;
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new WinningItemException();
        }
    }
}
