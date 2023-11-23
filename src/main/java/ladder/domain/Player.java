package ladder.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Player {
    private final String name;

    private Player(String name) {
        this.name = validateName(name);
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private String validateName(String name) {
        return Optional.ofNullable(name)
                .map(String::trim)
                .filter(Predicate.not(String::isBlank))
                .filter(text -> text.length() <= 5)
                .orElseThrow(() -> new IllegalArgumentException("유저의 이름은 1 ~ 5자리로 이루어져야 합니다."));
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
