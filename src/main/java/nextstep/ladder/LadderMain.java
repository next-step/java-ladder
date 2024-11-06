package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        List<String> results = InputView.inputResults();
        int height = InputView.inputHeight();
        ResultView.printLadderResult(usernames, new Lines(height, usernames.size()));
        String resultUserName = InputView.inputResultUserName();
    }
}
