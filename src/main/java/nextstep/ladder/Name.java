package nextstep.ladder;

public class Name {
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 null이거나 비어있을 수 없습니다.");
        }

        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("이름의 길이가 5를 초과할 수 없습니다.");
        }

        this.name = name;
    }
}
