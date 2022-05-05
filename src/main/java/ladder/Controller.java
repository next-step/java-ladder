package ladder;

import ladder.exception.InvalidHeightOfLadderException;
import ladder.exception.InvalidNameOfParticipant;
import ladder.exception.InvalidNumberOfParticipants;
import ladder.view.InputView;

import java.util.Scanner;

public class Controller {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR_OF_NAMES = ",";
    private static final String ERROR_MESSAGE_OF_HEIGHT_OF_LADDER = "ERROR] 사다리 높이는 숫자를 입력해야 합니다.";

    public static void main(String[] args) {
        String[] namesOfParticipants;
        while (true) {
            try {
                namesOfParticipants = InputView.inputNames().split(SEPARATOR_OF_NAMES);
                InputView.validateNumberOfParticipants(namesOfParticipants);
                InputView.validateNameOfParticipants(namesOfParticipants);
                break;
            } catch (InvalidNumberOfParticipants e) {
                System.out.println(e.getMessage());
            } catch (InvalidNameOfParticipant e) {
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


    }
}
