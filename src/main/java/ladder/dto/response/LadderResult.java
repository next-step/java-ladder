package ladder.dto.response;

import ladder.domain.Ladder;
import ladder.domain.player.Player;
import ladder.domain.Prize;
import java.util.Iterator;
import java.util.Map;

public class LadderResult implements Iterable<Map.Entry<Player, Prize>> {
    private final Ladder ladder;
    private final Map<Player, Prize> data;

    public LadderResult(Ladder ladder, Map<Player, Prize> data) {
        this.ladder = ladder;
        this.data = data;
    }

    public Ladder ladder() {
        return ladder;
    }

    public Prize prize(Player player) {
        return data.get(player);
    }

    @Override
    public Iterator<Map.Entry<Player, Prize>> iterator() {
        return data.entrySet().iterator();
    }
}