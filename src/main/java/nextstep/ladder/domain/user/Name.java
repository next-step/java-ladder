package nextstep.ladder.domain.user;

public class Name {
    private final String value;

    public Name(String name) {
        validate(name);
        this.value = name;
    }

    private static void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람이름은 최대 5자 입니다.");
        }
        if (name.equals("all")){
            throw new IllegalArgumentException("사람이름은 all이 될 수 없습니다");
        }
    }

    public String getValue() {
        return value;
    }
}
