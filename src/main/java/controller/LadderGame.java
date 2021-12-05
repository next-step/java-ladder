package controller;

import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.stream.Collectors;

import static util.StringUtils.separateStringWithComma;

public class LadderGame {
    public static final String ALL_PARTICIPANTS = "all";

    private LadderGame() {

    }

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        outputView.showRequestOfParticipants();
        String rawInputNames = inputView.getParticipantsNames();
        String[] participantNames = separateStringWithComma(rawInputNames);
        Participants participants = Participants.of(participantNames);

        outputView.showRequestOfLadderResult();
        String rawInputLadderResult = inputView.getLadderResult();
        String[] ladderResult = separateStringWithComma(rawInputLadderResult);

        outputView.showRequestOfHeightOfLadder();
        int heightOfLadder = inputView.getHeightOfLadder();
        Floors floors = Floors.of(heightOfLadder, participants.size());
        Ladder ladder = new Ladder(floors, new LadderResult(Arrays.stream(ladderResult).collect(Collectors.toList())));

        outputView.showMessageOfResult();
        outputView.showParticipants(participants);
        outputView.showLadder(ladder);
        outputView.showResults(ladderResult);

        String participant;
        do {
            outputView.showRequestForResultOfParticipant();
            participant = inputView.getParticipantForResult();
            outputView.showResultOfLadderGame(participant, participants, ladder);
        } while (!participant.equals(ALL_PARTICIPANTS));
    }
}
