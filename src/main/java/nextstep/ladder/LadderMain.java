package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.utils.StringUtils;

import java.util.List;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.*;

public class LadderMain {
    public static void main(String[] args) {
        String participantNames = inputParticipantNames();
        Participants participants = new Participants(participantNames);

        String playResults = inputPlayResults();
        List<String> resultList = StringUtils.splitByComma(playResults);

        int height = inputLadderHeight();
        Ladder ladder = LadderGenerator.generateLadder(participants.getParticipantCount(), height);

        LadderPrinter printer = new LadderPrinter(ladder);
        printLadderStatus(participants.getParticipantNames(), printer.printLadder(), resultList);

        LadderGame game = new LadderGame(participants, ladder);
        GameResult gameResult = game.play(resultList);
        printPlayResultForLoop(gameResult);
    }

    private static void printPlayResultForLoop(GameResult gameResult) {
        while (true) {
            String name = inputNameForResult();
            if ("all".equals(name)) {
                break;
            }
            printResult(gameResult.findResultByName(name));
        }
        printAllResult(gameResult.getResultMap());
    }
}
