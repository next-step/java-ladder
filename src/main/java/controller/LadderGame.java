package controller;

import domain.Ladder;
import domain.ParticipantFactory;
import domain.Participants;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private static final String COMMA = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        outputView.showRequestOfParticipants();
        String rawInputNames = inputView.getParticipantsNames();
        String[] participantNames = separateStringWithComma(rawInputNames);

        ParticipantFactory participantFactory = new ParticipantFactory(participantNames);
        Participants participants = participantFactory.produceParticipants();

        outputView.showRequestOfHeightOfLadder();
        int heightOfLadder = inputView.getHeightOfLadder();
        Ladder ladder = new Ladder(heightOfLadder, participants.size());

        outputView.showMessageOfResult();
        outputView.showParticipants(participants);
        outputView.showResult(ladder);
    }

    private static String[] separateStringWithComma(String string) {
        return string.replaceAll(REGEX_WHITESPACE, EMPTY_STRING).split(COMMA);
    }
}
