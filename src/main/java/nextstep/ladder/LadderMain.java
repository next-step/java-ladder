package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        List<String> usernameStrs = InputView.inputUserNames();
        Usernames usernames = new Usernames(usernameStrs);
        int height = InputView.inputMaxHeight();
    }
}
