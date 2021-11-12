package controller;

import domain.Floors;
import domain.Ladder;
import domain.ParticipantFactory;
import domain.Participants;
import view.ConsoleInputView;
import view.InputView;

public class LadderGame {
    private static final String COMMA = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        String rawInputNames = inputView.getParticipantsNames();
        String[] participantNames = separateStringWithComma(rawInputNames);

        ParticipantFactory participantFactory = new ParticipantFactory(participantNames);
        Participants participants = participantFactory.produceParticipants();

        int heightOfLadder = inputView.getHeightOfLadder();
        Ladder ladder = new Ladder(heightOfLadder, participants.size());
    }

    private static String[] separateStringWithComma(String string) {
        return string.replaceAll(REGEX_WHITESPACE, EMPTY_STRING).split(COMMA);
    }
}
