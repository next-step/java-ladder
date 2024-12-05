package nextstep.ladder;

import java.util.List;

public class LadderMain2 {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        List<String> results = InputView.inputResults();
        if (usernames.size() != results.size()) {
            throw new IllegalArgumentException("참여할 사람 수와 입력한 실행 결과의 수가 다릅니다.");
        }
        Ladder2 ladder = new Ladder2(InputView.inputHeight(), usernames.size());
        ResultView.printUsernames(usernames);
        ResultView.printLadder2(ladder);
        ResultView.printResults(results);

        String resultUserName = InputView.inputResultUserName();
//        ResultView.printResult(ladder.getResult(resultUserName));
    }
}
