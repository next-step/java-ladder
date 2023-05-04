package ladder.model;

public class Name {
    private final String value;

    public Name(String value) {
        //TODO add constraint (5글자 까지)
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
