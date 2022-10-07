package ladder.model;

public class UserName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public UserName(String name) {
        if (isInvalidName(name)){
            throw new IllegalArgumentException("유효하지 않은 사용자 이름입니다.");
        }
        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
    }

}
