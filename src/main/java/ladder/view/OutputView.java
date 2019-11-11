package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.stream.Collectors;

public class OutputView {

    private static final int PADDING = 1;
    private static final String BLANK = " ";

    public static void showLadder(Ladder ladder) {
        showPlayers(ladder.getPlayers());
        showBridges(ladder);
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
}
