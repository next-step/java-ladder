package nextstep.ladder.domain;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class LadderGameResult {
    protected Map<Player, Prize> ladderGameResult;

    public LadderGameResult() {}

    public void add(Player player, Prize prize) {
        this.ladderGameResult.put(player, prize);
    }

    public Map<Player, Prize> getValue() {
        return this.ladderGameResult;
    }

    public Prize findByPlayer(String playerName) {
        AtomicReference<Prize> prize = new AtomicReference<>();

        ladderGameResult.forEach((key, value) -> {
            if (key.isMatchedName(playerName)) {
                prize.set(value);
            }
        });

        ladderGameResult.entrySet()
                .stream()
                .filter(result -> result.getKey()
                        .isMatchedName(playerName))
                .forEach(result -> prize.set(result.getValue()));

        if (prize.get() == null) {
            throw new IllegalArgumentException("참가자 이름이 유효하지 않습니다.");
        }

        return prize.get();
    }
}
