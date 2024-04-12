package ladder;

import java.util.Optional;

public class Player {
    private String name;

    public Player(String name) {
        if(name.length() > 5){
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
