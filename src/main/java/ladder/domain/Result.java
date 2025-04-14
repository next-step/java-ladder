package ladder.domain;

public class Result {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Result(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 5글자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
