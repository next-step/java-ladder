package refactoring.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Name> players;

    private Players(String[] names) {
        validate(names);
        this.players = Arrays.stream(names).map(Name::new).collect(Collectors.toList());
    }

    public static Players of(final String[] names) {
        return new Players(names);
    }

    public int size() {
        return players.size();
    }

    public List<Name> getNames() {
        return players;
    }

    public String getName(final int i) {
        return players.get(i).get();
    }

    public int getIndex(final String target) {
       return IntStream.range(0, players.size()).filter(i -> players.get(i).get().equals(target))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 참가자 입니다."));
    }

    private void validate(final String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("중복된 참여자입니다.");
        }
    }
}
