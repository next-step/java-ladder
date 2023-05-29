package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.LadderGameDto;
import nextstep.ladder.dto.LadderInput;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LadderInput ladderInput = inputView.initRadderInformation();

        LadderGame ladderGame = new LadderGame();//사다리 게임
        Users users = Users.of(ladderInput.getUsers());//유저
        PointGenerator generator = new RandomPointGenerator();//사다리 생성전략
        Ladder ladder = Ladder.of(ladderInput.getUsersSize(), ladderInput.getHeight(), generator);//사다리
        InputResults results = new InputResults(ladderInput.getResults());//입력한 결과
        ResultView resultView = new ResultView();//출력 view 생성
        resultView.printLadder(users.toUserDtos(), ladder.toLadderDto(), results.getResults());//사다리 출력
        LadderGameDto ladderGameDto = ladderGame.play(users, ladder, results);
        while (true) {
            resultView.printResult(inputView.initResultInput(), ladderGameDto);
        }
    }
}
