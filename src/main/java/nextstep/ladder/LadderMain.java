package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        List<String> results = InputView.inputResults();
        int height = InputView.inputHeight();
        Lines lines = new Lines(height, usernames.size());
        ResultView.printLadderResult(usernames, lines, results);

        String resultUserName = InputView.inputResultUserName();
        String result = Result.getResult(resultUserName, usernames, lines, results);
        ResultView.printResult(result);
    }
}
