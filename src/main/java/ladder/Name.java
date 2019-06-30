package ladder;

public class Name {
    public static int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d 글짜를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
