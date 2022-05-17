package ladder.domain;

public class Participant {
    private final Name name;

    public Participant(Name name) {
        validateName(name);
        this.name = name;
    }

    public static Participant create(String name) {
        return new Participant(new Name(name));
    }

    public int nameLength() {
        return name.length();
    }

    private void validateName(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("사람 이름은 null 일 수 없습니다.");
        }
    }
}
