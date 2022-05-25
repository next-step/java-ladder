package nextstep.ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name){
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름의 길이는 최대 5글자 까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
