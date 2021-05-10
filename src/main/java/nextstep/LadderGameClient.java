package nextstep;

import nextstep.model.*;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGameClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesString = inputView.inputQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = namesString.split(",");
        Players players = new Players(names);
        String resultString = inputView.inputQuestion("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        LadderResult ladderResult = new LadderResult(namesString, resultString);

        String ladderCountString = inputView.inputQuestion("최대 사다리 높이는 몇 개인가요?");


        int ladderCount = Integer.parseInt(ladderCountString);
        ResultView resultView = new ResultView(ladderCount);

        Ladder ladder = new Ladder(ladderCount, names);

        resultView.printAll(ladder, players);

        String targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        Games games = new Games(ladder);
        resultView.print("실행 결과");
        resultView.print(games.personResult(names, players, new Player(targetPerson), ladderResult));

        targetPerson = inputView.inputQuestion("결과를 보고 싶은 사람은?");
        resultView.print("실행 결과");
        resultView.print(games.personResult(names, players, new Player(targetPerson), ladderResult));
    }
}
