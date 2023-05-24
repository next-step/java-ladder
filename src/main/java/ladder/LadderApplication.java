package ladder;

import ladder.domain.*;
import ladder.dto.GameResultDto;
import ladder.generator.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import javax.xml.transform.Result;
import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<User> userList = InputView.inputUsers();
        Users users = Users.create(userList);

        GameResult gameResult = InputView.inputLadderGameResults();

        int height = InputView.inputHeight();
        Ladder ladder = Ladder.create(userList.size(), height, new RandomPointGenerator());

        ResultView.printLadderInfoMessage();
        ResultView.printUsers(users);
        ResultView.printLadder(ladder);
        ResultView.printLadderGameResult(gameResult);

        LadderGame ladderGame = new LadderGame(users, ladder, gameResult);
        List<GameResultDto> gameResultDtos = ladderGame.execute();
        ResultView.printGamesResult(gameResultDtos);
    }
}
