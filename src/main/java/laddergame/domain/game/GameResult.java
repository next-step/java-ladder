package laddergame.domain.game;

import laddergame.domain.player.Player;
import laddergame.domain.vo.Name;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Map<Player, Prize> winningResults;

    public GameResult(final Map<Player, Prize> winningResults) {
        this.winningResults = Objects.requireNonNull(winningResults, "게임 결과를 찾을 수 없습니다.");
    }

    public Prize findByName(final Name name) {
        return winningResults.entrySet().stream()
                .filter(entry -> entry.getKey().isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지않는 이름입니다. - " + name))
                .getValue();
    }

    public Map<Player, Prize> findAll() {
        return Collections.unmodifiableMap(winningResults);
    }
}
