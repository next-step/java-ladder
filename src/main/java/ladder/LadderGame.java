package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {

        // 게임 정보 입력
        InputView inputView = new InputView();
        List<String> names = inputView.names();
        List<String> results = inputView.results();
        int height = inputView.height();
        Ladder ladder = Ladder.create(names, height, results);

        // 사다리 출력
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder);

        // 결과 확인하기
        String name = inputView.who();
        outputView.printResult(ladder, name);
    }
}
