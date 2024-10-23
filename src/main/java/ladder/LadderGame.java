package ladder;


import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;

import java.util.List;

public class LadderGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LadderGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        // 참여하는 사람 이름 입력
        outputHandler.showCommentForNamesOfPlayers();
        List<String> namesOfPeople = inputHandler.getNamesOfPlayers();
        Players players = Players.of(namesOfPeople);

        System.out.println();

        // 사다리 높이 입력
        outputHandler.showCommentForHeightOfLadder();
        int heightOfLadder = inputHandler.getHeightOfLadder();
        Ladder ladder = new Ladder(heightOfLadder, namesOfPeople.size());

        System.out.println();

        // 실행 결과 출력
        outputHandler.showLadderGameResult(players, ladder);
    }

}
