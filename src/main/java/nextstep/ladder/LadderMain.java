package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        List<String> results = InputView.inputResults();
        if (usernames.size() != results.size()) {
            throw new IllegalArgumentException("참여할 사람 수와 입력한 실행 결과의 수가 다릅니다.");
        }
        Ladder ladder = new Ladder(usernames.size(), InputView.inputHeight());
        ResultView.printUsernames(usernames);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);

        String resultUserName = InputView.inputResultUserName();
        ResultView.printResult(resultUserName, usernames, ladder, results);
    }
}
