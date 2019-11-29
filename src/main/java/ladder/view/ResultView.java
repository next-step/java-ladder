package ladder.view;

import ladder.game.LadderGame;
import ladder.game.Participants;
import ladder.game.Prize;
import ladder.game.Results;
import ladder.structure.Ladder;
import ladder.structure.LineOfLadder;
import ladder.structure.connection.result.Point;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행결과";
    private static final String EMPTY = "";
    private static final String PADDING_LADDER = "    ";
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String EMPTY_HORIZON = "     ";
    private static final String PARTICIPANT_FORMAT = "%6s";
    private static final String RESULT_FORMAT = "%6s";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String ALL = "all";

    public static void showLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame.getLadder());
        showResults(ladderGame.getPrizes().values());
    }

    public static boolean showResultOfParticipant(LadderGame ladderGame, String name) {
        if (EMPTY.equals(name)) {
            return false;
        }
        System.out.println(GAME_RESULT);
        Results results = ALL.equals(name)
                ? ladderGame.checkPrizesByParticipant()
                : ladderGame.checkPrizesByParticipant(name);
        results.values()
                .forEach((user, result)
                        -> System.out.println(String.format(GAME_RESULT_FORMAT, user, result)));
        return true;
    }

    private static void showParticipant(Participants participants) {
        List<String> names = participants.toStrings();
        for (String name : names) {
            System.out.print(String.format(PARTICIPANT_FORMAT, name));
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(Ladder ladder) {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            System.out.print(PADDING_LADDER + VERTICAL);
            drawLine(line);
            System.out.println(EMPTY);
        }
    }

    private static void drawLine(LineOfLadder line) {
        Map<Integer, Point> lineIndexWithPoint = line.getPoints().getPoints().stream()
                .collect(Collectors.toMap(Point::getColumn, point -> point));
        for (int i = 0; i < lineIndexWithPoint.size() - 1; i++) {
            drawConnection(lineIndexWithPoint.get(i).getDirection());
        }
    }

    private static void drawConnection(int openToRight) {
        if (openToRight == 1) {
            System.out.print(HORIZON + VERTICAL);
        } else {
            System.out.print(EMPTY_HORIZON + VERTICAL);
        }
    }

    private static void showResults(List<Prize> prizes) {
        for (Prize prize : prizes) {
            String result = prize.toString();
            System.out.print(String.format(RESULT_FORMAT, result));
        }
        System.out.println(EMPTY);
    }
}
