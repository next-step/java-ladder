package nextstep;

import nextstep.model.OnlineLadder;
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
        OnlineLadder ladder = new OnlineLadder(ladderCount, names.length - 1, names);
        resultView.printAll(ladder);

//        OnlineLadder ladder2 = new OnlineLadder(ladderCount, names.length - 1, names);
//        resultView.printAll(ladder2);
//        resultView.printAll(ladder2);
    }
}
