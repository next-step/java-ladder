package ladder.domain.player;

import java.util.List;

public interface PlayerGenerator {
  List<Player> generatePlayerList(List<String> players);
}
