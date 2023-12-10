package ladder.domain;

public class Participant {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ".repeat(MAX_LENGTH - name.length() + 1);
    }
}
