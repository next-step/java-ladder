package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Destination;
import ladder.domain.result.Destinations;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.stream.Collectors;

public class OutputView {

    private static final int PADDING = 1;
    private static final String BLANK = " ";
    private static final String END_COMMAND = "all";

    public static void showLadder(Ladder ladder, Destinations destinations) {
        showPlayers(ladder.getPlayers());
        showBridges(ladder);
        showResult(ladder, destinations);
    }

    private static void showPlayers(Players players) {
        int maxLength = players.getMaxLength() + PADDING;
        StringBuilder format = getFormat(maxLength);

        String topLine = players.getPlayers().stream()
                .map(Player::getName)
                .map(name -> String.format(format.toString(), name))
                .collect(Collectors.joining());

        System.out.println(topLine);
    }

    private static StringBuilder getFormat(int maxLength) {
        return new StringBuilder("%").append(maxLength).append("s");
    }

    private static void showBridges(Ladder ladder) {
        int maxLength = ladder.getMaxLength();
        int range = ladder.getRange();
        //높이만큼
        for (int y = 1; y <= ladder.getHeight(); y++) {
            //공백 출력
            showBlank(maxLength);
            //사람수만큼
            showBridgeWithoutLast(ladder, y);
            //마지막 브릿지 출력
            Direction direction = ladder.getDirection(range - 1, y);
            showLastBridge(direction);
        }
    }

    private static void showBridgeWithoutLast(Ladder ladder, int y) {
        for (int x = 0; x < ladder.getRange() - 1; x++) {
            Direction direction = ladder.getDirection(x, y);
            showBridgeWithoutLast(direction, ladder.getMaxLength());
        }
    }

    private static void showBlank(int length) {
        StringBuilder blank = getBlank(length);
        System.out.print(blank.toString());
    }

    private static StringBuilder getBlank(int length) {
        StringBuilder blank = new StringBuilder();
        for (int i = 0; i < length; i++) {
            blank.append(BLANK);
        }
        return blank;
    }

    private static void showBridgeWithoutLast(Direction direction, int length) {
        BridgeFrontGroup frontByDirection = BridgeFrontGroup.findFrontByDirection(direction);
        String frontValue = frontByDirection.getFrontValue();
        String sides = BridgeFrontGroup.getSide(length);
        if (direction.equals(Direction.RIGHT)) {
            System.out.print(frontValue + sides);
            return;
        }
        System.out.print(frontValue + getBlank(length));
    }

    private static void showLastBridge(Direction direction) {
        System.out.println(BridgeFrontGroup.findFrontByDirection(direction).getFrontValue());
    }

    private static void showResult(Ladder ladder, Destinations destinations) {
        Results results = ladder.makeResults(destinations);
        Players players = ladder.getPlayers();

        StringBuilder prizes = new StringBuilder();
        int maxLength = players.getMaxLength() + PADDING;
        for (Destination destination : destinations.getDestinations()) {
            prizes.append(String.format(getFormat(maxLength).toString(), destination.getReward()));
        }
        System.out.println(prizes.toString());

        showResultByCommand(results);
    }

    private static void showResultByCommand(Results results) {
        String command = null;
        while (!END_COMMAND.equals(command)) {
            System.out.println("결과를 보고 싶은 사람은?");
            command = InputView.inputResultCommand();
            showEachResult(results, command);
        }
        System.out.println("실행 결과");
        System.out.println(makeAllResult(results));
    }

    private static void showEachResult(Results results, String command) {
        if (END_COMMAND.equals(command)) {
            return;
        }
        Result result = results.findByName(command);
        System.out.println(result.getReward());
    }

    private static String makeAllResult(Results results) {
        return results.getResults().stream()
                .map(OutputView::makeAllResult)
                .collect(Collectors.joining());
    }

    private static String makeAllResult(Result result) {
        return new StringBuilder(result.getPlayerName()).append(" : ").append(result.getReward()).append("\n").toString();
    }
}
