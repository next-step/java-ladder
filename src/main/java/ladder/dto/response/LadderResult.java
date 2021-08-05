package ladder.dto.response;

import ladder.domain.Ladder;
import ladder.domain.player.Player;
import ladder.domain.Prize;
import java.util.Iterator;
import java.util.Map;

public class LadderResult implements Iterable<Map.Entry<Player, Prize>> {
    private final Ladder ladder;
    private final Map<Player, Prize> results;

    public LadderResult(Ladder ladder, Map<Player, Prize> results) {
        this.ladder = ladder;
        this.results = results;
    }

    public Ladder ladder() {
        return ladder;
    }

    public Prize prize(Player player) {
        return results.get(player);
    }

    @Override
    public Iterator<Map.Entry<Player, Prize>> iterator() {
        return results.entrySet().iterator();
    }
}