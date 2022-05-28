package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Participant(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
        validateNameLength(name);
        this.name = name;
    }

    public static List<Participant> create(List<String> names) {
        return names.stream().map(Participant::new).collect(Collectors.toList());
    }

    public int nameLength() {
        return name.length();
    }

    public boolean isParticipant(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("사람 이름은 1 ~ 5 글자를 만족해야 합니다. 현재 이름 길이 : %d", name.length()));
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
