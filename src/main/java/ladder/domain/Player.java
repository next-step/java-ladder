/*
 * 사다리타기 게임 참여자를 담당하는 클래스
 * */
package ladder.domain;

import java.util.Objects;
import java.util.Set;

public class Player {
    private Name name;

    public Player(Name name) {
        this.name = name;
    }

    public void addName(Set<Name> names) {
        names.add(name);
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
