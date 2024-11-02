package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        List<String> usernameStrs = InputView.inputUserNames();
        int height = InputView.inputHeight();
        ResultView.printLadderResult(new Usernames(usernameStrs), new Ladder(height, usernameStrs.size()));
    }
}
