package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.*;

import java.util.List;


public class LadderClient {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        IOHandler ioHandler = new IOHandler(inputView, outputView);
        List<Participant> participants = ioHandler.insertParticipant();
        List<Destination> destinations = ioHandler.insertExecutionResults();
        Height height = ioHandler.insertHeight();

        LadderIOHandler ladderIOHandler = new LadderIOHandler(inputView, outputView);
        Lines lines = new Lines(height.getSize(), participants.size());
        ladderIOHandler.printLadder(participants, lines, destinations);

        LadderMapping ladderMapping = new LadderMapping(participants, destinations);
        LadderMapping reOrderedLadderMapping = lines.switchOrder(ladderMapping);
        new ResultIOHandler(inputView, outputView).print(reOrderedLadderMapping);
    }
}
