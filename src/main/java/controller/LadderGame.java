package controller;

import domain.Ladder;
import domain.Participants;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import static util.StringUtils.separateStringWithComma;

public class LadderGame {

    private LadderGame() {

    }

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        outputView.showRequestOfParticipants();
        String rawInputNames = inputView.getParticipantsNames();
        String[] participantNames = separateStringWithComma(rawInputNames);

        Participants participants = new Participants(participantNames);
        participants.produceParticipants();

        outputView.showRequestOfHeightOfLadder();
        int heightOfLadder = inputView.getHeightOfLadder();
        Ladder ladder = new Ladder(heightOfLadder, participants.size());

        outputView.showMessageOfResult();
        outputView.showParticipants(participants);
        outputView.showResult(ladder);
    }


}
