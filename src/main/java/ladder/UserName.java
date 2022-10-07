package ladder;

public class UserName {

    private final String name;

    public UserName(String name) {
        if (isInvalidName(name)){
            throw new IllegalArgumentException("유효하지 않은 사용자 이름입니다.");
        }
        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.isBlank() || name.length() > 5;
    }

}
