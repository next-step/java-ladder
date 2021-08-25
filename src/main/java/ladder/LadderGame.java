package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {

        // 게임 정보 입력
        InputView inputView = new InputView();
        List<String> names = inputView.names();
        List<String> results = inputView.results();
        Ladder ladder = Ladder.create(inputView.height(), names.size());
        LadderResult ladderResult = new LadderResult(names, results);

        // 사다리 출력
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder, ladderResult);

        // 결과 확인하기
        String name = inputView.who();
        outputView.printResult(ladder, ladderResult, name);
    }
}
