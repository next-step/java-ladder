package ladder_v2.domain;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}
