package nextstep.ladder.controller.dto;

import nextstep.ladder.domain.Coordinate;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.WinningPrize;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.util.LadderBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameInfo {

    private String[] names;
    private int height;
    private String[] prizes;

    public GameInfo(String[] names, int height) {
        this.names = names;
        this.height = height;
    }

    public Ladder ladder() {
        return LadderBuilder.build(new Width(names.length - 1), new Height(height));
    }

    public Players players() {
        return new Players(IntStream.range(0, names.length)
            .mapToObj(i -> new Player(names[i], Coordinate.of(i, 0)))
            .collect(Collectors.toUnmodifiableList()));
    }

    public WinningPrize winningPrize() {
        return new WinningPrize(List.of(prizes), height);
    }
}
