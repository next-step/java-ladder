package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    public static final int START_POINT = 1;
    private Players players;
    private Ladder ladder;

    public LadderGame(GameInfo gameInfo) {
        this.players = new Players(IntStream.range(0, gameInfo.names().length)
            .mapToObj(i -> Player.PlayerBuilder.builder()
                .name(gameInfo.names()[i])
                .widthPosition(i)
                .heightPosition(START_POINT)
                .build())
            .collect(Collectors.toUnmodifiableList()));

        this.ladder = gameInfo.ladder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(players, that.players) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, ladder);
    }
}
