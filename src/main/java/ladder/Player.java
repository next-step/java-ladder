package ladder;

public class Player {

    private final String name;

    private Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
        if ("".equals(name)) {
            throw new IllegalArgumentException("이름은 최소 1글자 이상 입력하세요.");
        }
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
