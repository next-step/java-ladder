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
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return value.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
