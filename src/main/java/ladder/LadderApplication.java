package ladder;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        UserNames userNames = InputView.inputUserName();
        List<String> awards = InputView.inputGameAwards(); // 실행 결과 입력
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(userNames.size(), ladderHeight);

        System.out.println(ladder.play(userNames.size()));

        ResultView.printResult(userNames, ladder, ladder.play(userNames.size()), awards);
    }
}
