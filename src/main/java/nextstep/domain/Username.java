package nextstep.domain;

public class Username {

    public static final int LENGTH_MAX = 5;

    private final String name;

    public Username(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    String.format("이름의 길이는 %d글자를 초과할 수 없습니다.", LENGTH_MAX));
        }
    }
}
