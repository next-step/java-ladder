package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Player;

@FunctionalInterface
public interface HorizontalMove {
    HorizontalLocation move(Player player);
}
