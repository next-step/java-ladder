package nextstep.ladder.view;

import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.WinningItems;

interface LadderInputView {

    Players playersNameInput();

    int ladderHeightInput();

    WinningItems winningItemNameInput(int countOfPlayers);

    String gameResultPlayerInput();
}
