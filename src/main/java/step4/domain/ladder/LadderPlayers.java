package step4.domain.ladder;

import step4.domain.ladder.dto.LadderGameInformationDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderPlayers {
    public static final String WHITE_SPACE = " ";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_NOT_JOINED_PLAYER = "%s는 참가하지 않았습니다.";
    public static final List<String> ALL_AND_END = Arrays.asList("all", "end");

    private final List<Player> players;

    public LadderPlayers(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public static LadderPlayers of(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(index -> Player.of(names.get(index), index))
                .collect(collectingAndThen(Collectors.toList(), LadderPlayers::new));
    }

    public String existsPlayer(String playerName) {
        boolean is = players.contains(new Player(playerName, Point.defaultPoint));
        if (!is && !isInputEqualsAllOrEnd(playerName)) {
            throw new NoSuchElementException(String.format(ERROR_NOT_JOINED_PLAYER, playerName));
        }
        return playerName;
    }

    private boolean isInputEqualsAllOrEnd(String name) {
        return ALL_AND_END.contains(name.toLowerCase());
    }

    public int count() {
        return players.size();
    }

    public String toString() {
        return players.stream()
                .map(Player::getName)
                .map(this::pad)
                .collect(Collectors.joining(WHITE_SPACE));
    }

    private String pad(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        IntStream.range(input.length(), MAXIMUM_NAME_LENGTH)
                .forEach(index -> inputBuilder.append(WHITE_SPACE));

        return inputBuilder.toString();
    }

    public Player pick(String name) {
        Player sourcePlayer = new Player(name, Point.defaultPoint);
        return players.stream()
                .filter(sourcePlayer::equals)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public LadderGameInformationDTO buildDTO(Ladder ladder, LadderResults ladderResults) {
        return new LadderGameInformationDTO.Builder()
                .ladder(ladder)
                .ladderResults(ladderResults)
                .players(players)
                .build();
    }
}
