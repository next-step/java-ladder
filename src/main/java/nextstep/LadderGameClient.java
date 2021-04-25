package nextstep;

import nextstep.model.OnlineLadder;
import nextstep.model.Player;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGameClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesString = inputView.inputQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String winnserString = inputView.inputQuestion("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String ladderCountString = inputView.inputQuestion("최대 사다리 높이는 몇 개인가요?");


        int ladderCount = Integer.parseInt(ladderCountString);
        ResultView resultView = new ResultView(ladderCount);
        String[] names = namesString.split(",");
        String[] winners = winnserString.split(",");
        OnlineLadder ladder = new OnlineLadder(ladderCount, names.length - 1, names);
        resultView.printAll(ladder);

        String targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        int winner = ladder.start(new Player(targetPerson));
        resultView.print(winners[winner]);
        resultView.print("실행 결과");

        targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        winner = ladder.start(new Player(targetPerson));
        resultView.print("실행 결과");
        resultView.print(winners[winner]);
    }
}
