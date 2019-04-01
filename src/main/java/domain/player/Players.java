package domain.player;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final String NAME_SEPARATOR = ",";

    private static final String REMOVE_REGEX_OF_NAME = " ";

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static Players generate(String names) {
        List<Player> players = Arrays.stream(split(replace(names)))
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    private static String[] split(String value) {
        return value.split(NAME_SEPARATOR);
    }

    private static String replace(String value) {
        return value.replaceAll(REMOVE_REGEX_OF_NAME, "");
    }

    public int size() {
        return this.players.size();
    }

    public int findIndexByName(String name) {
        Player target = new Player(name);
        return IntStream.range(0, this.players.size())
                .filter(i -> this.players.get(i).equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String beautify() {
        return this.players.stream()
                .map(player -> StringUtils.leftPad(player.beautify(), Player.MAX_NAME_LENGTH))
                .collect(Collectors.joining(" "));
    }

    public String beautify(int index) {
        return this.players.get(index).beautify();
    }
}
