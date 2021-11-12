package controller;

import domain.Participant;
import domain.ParticipantFactory;
import view.ConsoleInputView;
import view.InputView;

import java.util.List;

public class LadderGame {
    private static final String COMMA = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        String rawInputNames = inputView.getParticipantsNames();
//        String[] participantNames = separateStringWithComma(rawInputNames);
//        List<Participant> participants = new ParticipantFactory(participantNames);

        inputView.getHeightOfLadder();
    }

    private static String[] separateStringWithComma(String string) {
        return string.replaceAll(REGEX_WHITESPACE, EMPTY_STRING).split(COMMA);
    }
}
