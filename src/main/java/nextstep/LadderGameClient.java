package nextstep;

import nextstep.model.LadderResult;
import nextstep.model.OnlineLadder;
import nextstep.model.Player;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGameClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesString = inputView.inputQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String resultString = inputView.inputQuestion("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String ladderCountString = inputView.inputQuestion("최대 사다리 높이는 몇 개인가요?");


        int ladderCount = Integer.parseInt(ladderCountString);
        ResultView resultView = new ResultView(ladderCount);
        String[] names = namesString.split(",");
        OnlineLadder ladder = new OnlineLadder(ladderCount, names.length - 1, names, resultString);
        resultView.printAll(ladder);

        String targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        LadderResult result = ladder.start(new Player(targetPerson));
        resultView.print("실행 결과");
        resultView.print(result.personResult(new Player(targetPerson)));

        targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        resultView.print("실행 결과");
        result = ladder.start(new Player(targetPerson));
        resultView.print(result.personResult(new Player(targetPerson)));
    }
}
