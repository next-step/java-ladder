package ladder.domain.player;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import ladder.exception.InvalidPlayerNameException;
import ladder.exception.InvalidPlayerNamesException;

public class PlayerNames {

    private final List<PlayerName> names;

    private PlayerNames(List<PlayerName> names) {
        validate(names);
        this.names = names;
    }

    public static PlayerNames of(List<String> names) {
        return Optional.ofNullable(names)
                .orElseThrow(InvalidPlayerNamesException::new)
                .stream()
                .map(PlayerName::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), PlayerNames::new));
    }

    public PlayerName getNameByIndex(int index) {
        return Optional.ofNullable(names.get(index))
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    public int getIndexByName(String name) {
        PlayerName playerName = PlayerName.of(name);
        if (!names.contains(playerName)) {
            throw new InvalidPlayerNameException("입력하신 이름은 사다리 참여자가 아닙니다.");
        }
        return names.indexOf(playerName);
    }

    public int maxLength() {
        return names.stream()
                .mapToInt(PlayerName::length)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public int size() {
        return names.size();
    }

    public List<PlayerName> getNames() {
        return names;
    }

    private void validate(List<PlayerName> names) {
        if (names == null || names.isEmpty()) {
            throw new InvalidPlayerNamesException();
        }
    }

    @Override
    public String toString() {
        return "PlayerNames{" +
                "names=" + names +
                '}';
    }
}
