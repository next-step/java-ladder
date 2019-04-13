package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    public static final String ALL = "all";

    public static void printLadder(LadderGame ladderGame) {

        println("실행결과");
        println("==================================");

        ladderGame.getPlayers().forEach(player -> System.out.print(player.getName() + LadderGame.LADDER_EMPTY_WIDTH));
        System.out.println();
        ladderGame.getLadder().forEach(line -> {
            print(LadderGame.LADDER_SIDE);
            IntStream.range(0, line.getPoints().size() -1).forEach(index -> {
            drawLine(line.getPoints().get(index), ladderGame.maxWidthDrawTimes());
        });
            println("");
        });
    }

    private static void drawLine(Point point, int maxLadderWidth) {
        if(point.isRight()) {
            print(drawWidth(maxLadderWidth,LadderGame.LADDER_WIDTH));
            print(LadderGame.LADDER_SIDE);
            return;
        }
        print(drawWidth(maxLadderWidth,LadderGame.LADDER_EMPTY_WIDTH));
        print(LadderGame.LADDER_SIDE);
    }

    private static String drawWidth(int maxLadderWidth, String widthType) {
        final StringBuilder ladderWidth = new StringBuilder("");

        IntStream.range(0, maxLadderWidth).forEach(count -> {
            ladderWidth.append(widthType);
        });
        return ladderWidth.toString();
    }

    public static void printInputResults(List<String> inputResults) {
        println("");
        for (String inputResult : inputResults) {
            print(inputResult + LadderGame.LADDER_EMPTY_WIDTH);
        }
        println("");
    }

    public static void printResult(String inputUserResult, LadderGameResult ladderGameResult) {
        println(getPlayResults(inputUserResult, ladderGameResult));
    }


    private static String getPlayResults(String userName, LadderGameResult ladderGameResult) {
        if(userName.equals(ALL)) {
            return getAllPlayResults(ladderGameResult.getPlayResults());
        }
        return getPlayResult(new Player(userName), ladderGameResult);
    }

    private static String getPlayResult(Player player, LadderGameResult ladderGameResult) {
        return ladderGameResult.findResult(player).getGameResult();
    }

    private static String getAllPlayResults(PlayResults playResults) {
        StringBuilder stringBuilder = new StringBuilder("");
        playResults.getPlayResults().forEach(playResult -> {
            String template = String.format("%s : %s \n", playResult.getName(), playResult.getGameResult());
            stringBuilder.append(template);
        });
        return stringBuilder.toString();
    }

    private static void print(String input) {
        System.out.print(input);
    }

    private static void println(String input) {
        System.out.println(input);
    }
}
