package ladder.model;

public class StringAsHeight {

    private final StringAsInteger stringAsInteger;

    public StringAsHeight(String height) {
        this.stringAsInteger = new StringAsInteger(height);
    }

    public Height height() {
        return new Height(stringAsInteger.intValue());
    }
}
