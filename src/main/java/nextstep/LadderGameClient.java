package nextstep;

import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGameClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesString = inputView.inputQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String ladderCountString = inputView.inputQuestion("최대 사다리 높이는 몇 개인가요?");


        int ladderCount = Integer.parseInt(ladderCountString);
        ResultView resultView = new ResultView(ladderCount);
        String[] names = namesString.split(",");
        OnlineLadder ladder = new OnlineLadder(ladderCount, null, names.length);
        for (int i = 0; i < ladderCount; i++) {
            ladder.lineMark(i);
        }
        resultView.printAll(ladder, names);
    }
}
