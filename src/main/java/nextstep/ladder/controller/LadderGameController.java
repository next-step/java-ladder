package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGameController {

    public static void main(String[] args) {
        try {
            List<String> names = InputView.readParticipantNames();
            int height = InputView.readLadderMaxHeight();

            LadderGame ladderGame = LadderGame.of(names, height);

            ResultView.printGameResult(ladderGame);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.", e);
        }

    }

}
