package ladder.model.stringas;

import ladder.model.Height;

public class StringAsHeight {

    private final StringAsInteger stringAsInteger;

    public StringAsHeight(String value) {
        this.stringAsInteger = new StringAsInteger(value);
    }

    public Height get() {
        return new Height(stringAsInteger.get());
    }
}
