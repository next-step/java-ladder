package ladder;

public class UserName {
    private static final int MAX_LENGTH = 5;

    private static final String LENGTH_OVER_ERROR = "아름의 길이는 1이상 5이하여야 합니다." ;

    private final String name;

    public UserName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR);
        }
    }
}
