package nextstep.ladder.domain;

public class UserName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    private UserName(String name) {
        this.name = name;
    }

    public static UserName add(String name) {
        validate(name);
        return new UserName(name);
    }

    private static void validate(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("사용자명은 최소 1자 입니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("사용자명은 최대 %s자 입니다.", MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

}
