package ladder.dto.response;

import ladder.domain.Ladder;
import ladder.domain.player.Player;
import ladder.domain.Prize;
import java.util.Iterator;
import java.util.Map;

public class LadderResult implements Iterable<Map.Entry<Player, Prize>> {
    private final Ladder ladder;
    private final Map<Player, Prize> prizeOfEachPlayer;

    public LadderResult(Ladder ladder, Map<Player, Prize> data) {
        this.ladder = ladder;
        this.prizeOfEachPlayer = data;
    }

    public Ladder ladder() {
        return ladder;
    }

    public Prize prize(Player player) {
        return prizeOfEachPlayer.get(player);
    }

    @Override
    public Iterator<Map.Entry<Player, Prize>> iterator() {
        return prizeOfEachPlayer.entrySet().iterator();
    }
}