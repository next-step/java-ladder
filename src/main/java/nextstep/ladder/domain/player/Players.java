package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.InputInvalidException;
import nextstep.ladder.domain.laddar.Ladder;
import nextstep.util.StringUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static nextstep.ladder.domain.laddar.LadderGame.DELIMITER_MARK;

public class Players {
    private final List<Player> players;

    private Players(final String args) {
        List<String> names = stream(args.split(DELIMITER_MARK))
                .collect(Collectors.toList());

        this.players = range(0, names.size())
                .mapToObj(createPlayerFrom(names))
                .collect(Collectors.toList());
    }

    private static IntFunction<Player> createPlayerFrom(final List<String> players) {
        return (int position) -> Player.of(getName(players, position), Position.from(position));
    }

    private static String getName(final List<String> players, final int position) {
        return players.get(position);
    }

    public static Players from(final String args) {
        verifyPlayerNames(args);
        return new Players(args);
    }

    private static void verifyPlayerNames(final String names) {
        if (StringUtils.isEmpty(names)) {
            throw new InputInvalidException("입력이 없습니다.");
        }

        if (!names.contains(DELIMITER_MARK)) {
            throw new InputInvalidException("입력이 잘못됐습니다.");
        }
    }

    public List<String> names() {
        return players.stream()
                      .map(Player::name)
                      .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> positions() {
        return players.stream()
                      .map(Player::position)
                      .map(Position::currentPosition)
                      .collect(Collectors.toUnmodifiableList());
    }

    public void ride(final Ladder ladder) {
        range(0, ladder.height()).forEach(moveStepByStep(ladder));
    }

    private IntConsumer moveStepByStep(final Ladder ladder) {
        return depth -> players.forEach(move(ladder, depth));
    }

    private Consumer<Player> move(final Ladder ladder, final int depth) {
        return player -> ladder.ride(player, depth);
    }

    public int size() {
        return players.size();
    }
}
