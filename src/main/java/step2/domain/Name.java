package step2.domain;

public class Name {

    private final String value;

    public Name(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하입니다");
        }
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%6s",value);
    }
}
