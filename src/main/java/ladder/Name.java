package ladder;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (name == null) {
            throw new NullPointerException("이름을 적어주세요.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 빈값이나 공백을 허용하지 않습니다..");
        }

        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 5자 이하로 적어주세요.");
        }

        this.name = name;
    }
}
