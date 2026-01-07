package nextstep.ladder;

public class Player {
    private final static int MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    private void validate(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 최대 5글자까지 가능합니다.");
        }
    }
}
