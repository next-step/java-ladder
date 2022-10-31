package nextstep.domain;

public class Player {
    public final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 4자 이하로 짧게 써야 한다.");
        }
    }

    public String getName() {
        return name;
    }
}
