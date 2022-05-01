package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Participants participants = createParticipants();
        Prizes prizes = createPrizes();
        Ladder ladder = createLines(participants.size());

        printGameStart(participants, prizes, ladder);
        LadderGameResult result = createGameResult(participants, prizes, ladder);
        printGameResult(result);
    }

    private static Participants createParticipants() {
        List<String> names = InputView.promptNames();
        return Participants.createParticipants(names);
    }

    private static Prizes createPrizes() {
        List<Integer> moneys = InputView.promptMoneys();
        return Prizes.createPrizes(moneys);
    }

    private static Ladder createLines(int width) {
        int height = InputView.promptHeight();
        return Ladder.createLadder(width, height);
    }

    private static void printGameStart(Participants participants, Prizes prizes, Ladder ladder) {
        OutputView.printParticipants(participants);
        OutputView.printLines(ladder);
        OutputView.printPrizes(prizes);
    }

    private static LadderGameResult createGameResult(Participants participants, Prizes prizes, Ladder ladder) {
        LadderGame ladderGame = new LadderGame(participants, ladder);
        ladderGame.play();
        LadderGameResult result = ladderGame.match(prizes);
        return result;
    }

    private static void printGameResult(LadderGameResult result) {
        String name = InputView.promptName();
        if (name.equals("all")) {
            OutputView.printEveryResult(result);
            return;
        }
        int prize = result.findPrizeByName(name);
        OutputView.printResult(name, prize);
    }
}
