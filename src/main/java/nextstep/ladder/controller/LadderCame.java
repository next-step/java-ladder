package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.util.StringParser;

import java.util.LinkedHashMap;
import java.util.Map;

import static nextstep.ladder.ui.InputView.*;
import static nextstep.ladder.ui.OutputView.*;

public class LadderCame {

    public static void main(String[] args) {
        Names participants = new Names(StringParser.split(personName()));
        Prizes prizes = new Prizes(StringParser.split(ladderPrize()));
        Height height = new Height(inputLadderHeight());
        Ladder ladder = new Ladder(height, participants.countOfParticipant());
        printLadder(participants, ladder, prizes);
        LadderResult ladderResult = new LadderResult(calculateLadderResult(participants, prizes, ladder));
        printLadderResult(inputLadderResultName(), ladderResult);
    }

    private static Map<Name, Prize> calculateLadderResult(Names participants, Prizes prizes, Ladder ladder) {
        Map<Name, Prize> results = new LinkedHashMap<>();
        for (int position = 0; position < participants.countOfParticipant(); position++) {
            results.put(participants.name(position), prizes.prize(ladder.climb(position)));
        }
        return results;
    }

    private static void printLadder(Names participants, Ladder ladder, Prizes prizes) {
        printParticipants(participants);
        printLines(ladder);
        printPrizes(prizes);
    }

}
