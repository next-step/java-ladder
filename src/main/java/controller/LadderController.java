package controller;

import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.List;

import static util.StringUtils.separateStringWithComma;

public class LadderController {
    public static final String ALL_PARTICIPANTS = "all";

    private LadderController() {

    }

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        outputView.showRequestOfParticipants();
        String rawInputNames = inputView.getParticipantsNames();
        List<String> participantNames = separateStringWithComma(rawInputNames);
        Participants participants = Participants.of(participantNames);

        outputView.showRequestOfLadderResult();
        String rawInputLadderResult = inputView.getLadderResult();
        List<String> separatedLadderResult = separateStringWithComma(rawInputLadderResult);
        LadderResult ladderResult = new LadderResult(separatedLadderResult);

        outputView.showRequestOfHeightOfLadder();
        int heightOfLadder = inputView.getHeightOfLadder();
        LadderGame ladderGame = new LadderGame(participants, heightOfLadder);

        outputView.showMessageOfResult();
        outputView.showParticipants(participants);
        outputView.showLadderGame(ladderGame);
        outputView.showResults(separatedLadderResult);

        String participantName;
        do {
            outputView.showRequestForResultOfParticipant();
            participantName = inputView.getParticipantForResult();
            outputView.showResultOfLadderGame(participantName, ladderResult, ladderGame);
        } while (!participantName.equals(ALL_PARTICIPANTS));
    }
}
