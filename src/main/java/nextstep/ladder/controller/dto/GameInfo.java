package nextstep.ladder.controller.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Players;
import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.util.LadderBuilder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameInfo {

    public static final int START_POINT = 1;

    private String[] names;
    private int height;

    public GameInfo(String[] names, int height) {
        this.names = names;
        this.height = height;
    }

    public Ladder ladder() {
        return LadderBuilder.build(new Width(names.length - 1), new Height(height));
    }

    public Players players() {
        return new Players(IntStream.range(0, names.length)
            .mapToObj(i -> Player.PlayerBuilder.builder()
                .name(names[i])
                .widthPosition(i)
                .heightPosition(START_POINT)
                .build())
            .collect(Collectors.toUnmodifiableList()));
    }
}
