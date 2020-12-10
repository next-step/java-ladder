package nextstep.ladder;

import nextstep.ladder.domain.LadderDto;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.LadderHeightInputView;
import nextstep.ladder.view.LadderStatePrintView;
import nextstep.ladder.view.UserInputView;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();

        LadderDto ladderDto = new LadderDto(users, ladderHeight);

        LadderStatePrintView.print(ladderDto);
    }

}
