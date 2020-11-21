package step3.view;

import step3.domain.ladder.LadderPlayers;

public interface InputView {

    String getPlayerNames();
    Integer getLadderHeight();
    String getLadderResult(int maxSize);
    String findResultByPlayer(LadderPlayers players);
}
