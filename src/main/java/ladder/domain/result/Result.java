package ladder.domain.result;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import ladder.domain.item.Item;
import ladder.domain.item.Items;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

public class Result {

    private final Map<Player, Item> result;

    private Result(final Map<Player, Item> result) {
        this.result = result;
    }

    public Map<Player, Item> getAll() {
        return Collections.unmodifiableMap(this.result);
    }

    public Item getOne(final String playerName) {
        final Player player = new Player(playerName);

        if (!this.result.containsKey(player)) {
            throw new IllegalArgumentException("결과를 보고 싶은 플레이어가 존재하지 않습니다. 이름: " + playerName);
        }

        final Item item = this.result.get(player);

        return item.copyOf();
    }

    public static Result of(final Players players, final Ladder ladder, final Items items) {
        validateAllCountsAreSame(players, ladder, items);

        final Map<Integer, Integer> route = ladder.move();
        final Map<Player, Item> result = new LinkedHashMap<>();

        for (int start = 0; start < players.count(); start++) {
            final int end = route.get(start);
            result.put(players.get(start), items.get(end));
        }

        return new Result(Collections.unmodifiableMap(result));
    }

    private static void validateAllCountsAreSame(final Players players, final Ladder ladder, final Items items) {
        if (isDifferentCount(players, ladder, items)) {
            throw new IllegalArgumentException("플레이어 수, 사다리 기둥 개수, 사다리 결과 개수가 동일하지 않습니다.");
        }
    }

    private static boolean isDifferentCount(final Players players, final Ladder ladder, final Items items) {
        return players.count() != ladder.width() ||
                ladder.width() != items.count() ||
                items.count() != players.count();
    }
}
