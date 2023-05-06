package nextstep.ladder;

public class PersonName {

    private final String name;

    public PersonName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
