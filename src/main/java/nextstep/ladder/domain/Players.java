package nextstep.ladder.domain;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    public static final String DELIMITER = ",";
    private static final int PLAYERS_MIN_COUNT = 2;
    private List<Name> players;

    public Players(String players) {
        this(toList(players));
    }

    private static List<Name> toList(String players) {
        duplicatedPlayersName(players);
        return Arrays.stream(players.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public Players(List<Name> players) {
        if (players.size() < PLAYERS_MIN_COUNT) {
            throw new IllegalArgumentException("참가자 수" + players.size() + " 게임을 진행하려면 최소 " + PLAYERS_MIN_COUNT + "명 이상 필요합니다.");
        }
        this.players = players;
    }

    public int indexOf(String player) {
        return players.indexOf(new Name(player));
    }

    private static void duplicatedPlayersName(String players) {
        String[] split = players.split(DELIMITER);
        Set<String> playerCollect = Arrays.stream(players.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toSet());
        if (split.length != playerCollect.size()) {
            throw new IllegalArgumentException("참여자 이름이 중복 되었습니다.");
        }
    }

    public boolean contains(String player) {
        return players.contains(new Name(player));
    }

    public int size() {
        return players.size();
    }

    public String name(int index) {
        return players.get(index).name();
    }

    public Stream<Name> stream() {
        return players.stream();
    }
}
