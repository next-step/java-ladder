package nextstep.ladder;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("사용자 이름은 5글자를 넘어가면 안됩니다.");
        }
        return new Player(name);
    }

    public String name() {
        return this.name;
    }
}
