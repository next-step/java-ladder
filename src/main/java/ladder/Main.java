package ladder;

import ladder.domain.Game;
import ladder.domain.PersonList;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //참여자 입력
        String[] personData = InputView.inputPersonData();
        PersonList personList = new PersonList(personData);

        //실행 결과 입력
        String[] resultData = InputView.inputResultData();
        Result result = new Result(resultData, personData);

        //사다리 높이 입력
        int ladderHeight = InputView.inputLadderHeight();

        //사다리 게임 생성
        Game game = new Game(personList, ladderHeight);

        //입력 결과 출력
        ResultView.inputDataInfo(game, result);

        //게임 진행
        game.playGame();

        //결과 검색
        String keyword = InputView.inputFindResultKeyword();
        List<String> findResult = result.findResult(game, keyword);

        //결과 출력
        if (findResult.size() == 1) {
            ResultView.printSingleResult(findResult);
        }
        if (findResult.size() != 1) {
            ResultView.printAllResult(findResult);
        }
    }
}
