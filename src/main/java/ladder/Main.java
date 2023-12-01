package ladder;

import ladder.domain.Game;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        //사다리 게임 데이터 입력 & 생성
        Game game = InputView.inputGameData();

        //입력 결과 출력
        ResultView.dataInputResult(game);
    }
}
