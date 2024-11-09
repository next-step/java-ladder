package nextstep.ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        List<String> results = InputView.inputResults();
        if (usernames.size() != results.size()) {
            throw new IllegalArgumentException("참여할 사람 수와 입력한 실행 결과의 수가 다릅니다.");
        }
        Ladder ladder = new Ladder(usernames, new Lines(InputView.inputHeight(), usernames.size()), results);
        ResultView.printLadder(ladder);

        String resultUserName = InputView.inputResultUserName();
        ResultView.printResult(ladder.getResult(resultUserName));
    }
}
