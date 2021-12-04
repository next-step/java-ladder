package ladder.model.stringas;

import ladder.model.Height;

public class StringAsHeight {

    private final StringAsInteger stringAsInteger;

    public StringAsHeight(String height) {
        this.stringAsInteger = new StringAsInteger(height);
    }

    public Height get() {
        return new Height(stringAsInteger.intValue());
    }
}
