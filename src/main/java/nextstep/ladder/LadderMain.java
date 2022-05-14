package nextstep.ladder;

import nextstep.ladder.domain.Members;
import nextstep.ladder.view.InputView;

public class LadderMain {
    public static void main(String[] args) {
        Members members = InputView.inputMemberNames();

        System.out.println("members = " + members);
    }
}
