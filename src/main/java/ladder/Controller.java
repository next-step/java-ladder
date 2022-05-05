package ladder;

import ladder.exception.InvalidNameOfParticipant;
import ladder.exception.InvalidNumberOfParticipants;
import ladder.view.InputView;

public class Controller {
    private static final String SEPARATOR_OF_NAMES = ",";

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
    }
}
