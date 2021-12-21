package ladder.domain;

public class Name implements LadderString {

    private final LadderStringValue ladderStringValue;

    public Name(String value) {
        this.ladderStringValue = new LadderStringValue(value);
    }

    public boolean match(String name) {
        return ladderStringValue.value().equals(name);
    }

    @Override
    public String value() {
        return ladderStringValue.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name name = (Name) o;

        return ladderStringValue != null ? ladderStringValue.equals(name.ladderStringValue) : name.ladderStringValue == null;
    }

    @Override
    public int hashCode() {
        return ladderStringValue != null ? ladderStringValue.hashCode() : 0;
    }

}
