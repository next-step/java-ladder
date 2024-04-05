package ladder.domain;

import java.util.Objects;

public class Player {

    private final String name;

    public Player(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        this.name = name;
    }

    public String name(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
