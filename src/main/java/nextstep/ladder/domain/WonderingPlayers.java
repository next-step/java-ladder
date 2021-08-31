package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WonderingPlayers {

    private static final String ALL = "all";

    public final List<Player> wonderingPlayers;

    public WonderingPlayers(final Players players, final String wonderingPlayer) {
        this.wonderingPlayers = Optional.of(wonderingPlayer)
                .filter(this::isAll)
                .map(all -> players.getPlayerNames())
                .orElse(Collections.singletonList(wonderingPlayer))
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> getWonderingPlayers() {
        return Collections.unmodifiableList(wonderingPlayers);
    }

    public boolean isEqualSizeTo(final Players players) {
        return this.wonderingPlayers.size() == players.count();
    }

    private boolean isAll(final String wonderingPlayer) {
        return wonderingPlayer.equals(ALL);
    }

}
