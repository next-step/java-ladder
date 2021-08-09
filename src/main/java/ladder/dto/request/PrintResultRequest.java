package ladder.dto.request;

import ladder.domain.Ladder;
import ladder.domain.player.Players;
import ladder.domain.Prize;
import java.util.List;

public class PrintResultRequest {
    private final Ladder ladder;
    private final List<Prize> prizes;
    private final Players players;

    public PrintResultRequest(final Ladder ladder, final List<Prize> prizes, final Players players) {
        this.ladder = ladder;
        this.prizes = prizes;
        this.players = players;
    }

    public Ladder ladder() {
        return ladder;
    }

    public List<Prize> prizes() {
        return prizes;
    }

    public Players players() {
        return players;
    }
}
