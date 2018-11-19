import game.ladder.domain.*;
import game.ladder.view.InputView;
import game.ladder.view.OutputView;

public class ConsoleMain {

    public static void main(String[] args) {
        Participants participants = InputView.readParticipant();

        Expects expects = InputView.readExpects();

        Height height = InputView.readHeight();

        LinesGenerator linesGenerator = new LinesGenerator(height);
        Ladder ladder = new Ladder(linesGenerator, participants, expects);

        OutputView.printLadder(ladder);

        GameResultCache gameResultCache = new GameResultCache(ladder);

        Name name;
        while (true) {
            name = InputView.readExpectParticipantName();
            GameResults gameResults = gameResultCache.getGameResults(name);
            OutputView.printGameResults(gameResults);

            if (name.equals(Name.ALL)) {
                break;
            }
        }

    }

}
