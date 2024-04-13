package ladder.domain;

import java.util.Optional;

public class Player {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름이 5자를 초과하였습니다.");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
