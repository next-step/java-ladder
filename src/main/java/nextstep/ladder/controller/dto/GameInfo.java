package nextstep.ladder.controller.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.WinningPrize;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.util.LadderBuilder;

import java.util.List;

public class GameInfo {

    private final String[] names;
    private final int height;
    private final String[] prizes;

    public GameInfo(String[] names, int height, String[] prizes) {
        this.names = names;
        this.height = height;
        this.prizes = prizes;
    }

    public Ladder ladder() {
        return LadderBuilder.build(new Width(names.length), new Height(height));
    }

    public Players players() {
        return new Players(List.of(names));
    }

    public WinningPrize winningPrize() {
        return new WinningPrize(List.of(prizes));
    }
}
