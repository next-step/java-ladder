package ladder;

import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.domain.Participants;
import ladder.exception.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {
    private static final String ERROR_MESSAGE_OF_HEIGHT_OF_LADDER = "ERROR] 사다리 높이는 숫자를 입력해야 합니다.";

    public static void main(String[] args) {
        // Input
        Participants participants;
        while (true) {
            try {
                String namesOfParticipants = InputView.inputNames();
                participants = new Participants(namesOfParticipants);
                break;
            } catch (InvalidNumberOfParticipantsException e) {
                System.out.println(e.getMessage());
            } catch (InvalidNameOfParticipantException e) {
                System.out.println(e.getMessage());
            }
        }

        int heightOfLadder;
        while (true) {
            try {
                heightOfLadder = InputView.inputHeightOfLadder();
                InputView.validateHeightOfLadder(heightOfLadder);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE_OF_HEIGHT_OF_LADDER);
            } catch (InvalidHeightOfLadderException e) {
                System.out.println(e.getMessage());
            }
        }

        GameResult result;
        while (true) {
            try {
                String gameResult = InputView.inputResult();
                result = new GameResult(gameResult, participants);
                break;
            } catch (InvalidNumberOfResultException e) {
                System.out.println(e.getMessage());
            } catch (InvalidNameOfReulstException e) {
                System.out.println(e.getMessage());
            }
        }

        // Logic
        LadderGame game = new LadderGame(participants.getNumberOfParticipants(), heightOfLadder);
        game.start(result);

        // Output
        ResultView.printNames(participants.getNamesOfParticipants());
        ResultView.printLadder(game.getLadder());
    }
}
