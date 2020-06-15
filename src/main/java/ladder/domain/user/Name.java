package ladder.domain.user;

public class Name {
    private final String name;

    public Name(String name) {
        isNotNullOrEmpty(name);
        this.name = name;
    }

    private void isNotNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }
}
