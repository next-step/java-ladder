package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerNames {
    private final List<PlayerName> names;

    public PlayerNames(List<PlayerName> names) {
        validateUnique(names);
        this.names = names;
    }

    private void validateUnique(List<PlayerName> names) {
        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public PlayerName findByName(String name) {
        return names.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어 이름입니다: " + name));
    }

    public int size() {
        return names.size();
    }

    public List<PlayerName> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int indexOf(PlayerName player) {
        int index = names.indexOf(player);
        if (index == -1) {
            throw new IllegalArgumentException("해당 플레이어는 목록에 존재하지 않습니다: " + player.getName());
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerNames that = (PlayerNames) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
