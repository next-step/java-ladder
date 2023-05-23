package ladder.domain.player;

import java.util.List;
import ladder.domain.ladder.player.LadderGamePlayerInfo;

public interface PlayerGenerator {
  LadderGamePlayerInfo generatePlayerList(List<String> players);
}
