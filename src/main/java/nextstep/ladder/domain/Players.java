package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {

    private List<String> players = new ArrayList<>();

    public Players(String[] people) {
        for (String person : people) {
            checkDuplicate(person);
            checkNameLength(person);
            this.players.add(person);
        }
    }

    private void checkNameLength(String person) {
        if (person.length() > 5) {
            throw new IllegalArgumentException("이름은 5자까지 입력 가능합니다.");
        }
    }

    private void checkDuplicate(String person) {
        if (this.players.contains(person)) {
            throw new IllegalArgumentException("이름은 중복으로 입력 불가합니다.");
        }
    }

    public int countPerson() {
        return players.size();
    }

    public List<String> getPerson() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players person1 = (Players) o;
        return Objects.equals(players, person1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
