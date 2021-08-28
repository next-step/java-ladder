package nextstep.ladder.domain.participant;

public class Name {

    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value.length() > 5)
            throw new IllegalStateException();
    }

    public String getValue() {
        return value;
    }
}
