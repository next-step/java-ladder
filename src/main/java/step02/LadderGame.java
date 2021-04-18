package step02;

import step02.dto.LadderGameDTO;
import step02.ladder.Ladder;
import step02.user.Users;
import step02.view.InputView;
import step02.view.ResultView;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame() throws IllegalAccessException {
        users = new Users(InputView.inputUserName());
        ladder = new Ladder(users.getUserCount(), InputView.inputLadderHeight());
    }

    public void showLadderGameResult() {
        LadderGameDTO ladderGameDTO = new LadderGameDTO();
        ladderGameDTO.setLadder(ladder);
        ladderGameDTO.setUsers(users);
        ResultView.showLadderResult(ladderGameDTO);
    }
}
