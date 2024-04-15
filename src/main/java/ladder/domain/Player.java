package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        if(name == null){
            throw new NullPointerException("이름을 입력해야합니다.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
