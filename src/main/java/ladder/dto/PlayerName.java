package ladder.dto;

import java.util.List;

public class PlayerName {
    private String name;

    public PlayerName() {

    }

    public PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    public static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자까지 가능합니다.");
        }
    }

    public String getName(){
        return this.name;
    }
}
