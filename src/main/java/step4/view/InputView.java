package step4.view;

import step4.domain.ladder.LadderPlayers;

public interface InputView {

    String getPlayerNames();
    Integer getLadderHeight();
    String getLadderResult(int maxSize);
    String findResultByPlayer(LadderPlayers players);
}
