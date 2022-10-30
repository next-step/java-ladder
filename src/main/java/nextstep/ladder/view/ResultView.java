package nextstep.ladder.view;

import nextstep.ladder.*;

import java.util.List;

import static nextstep.ladder.view.Shape.*;

public class ResultView {
    private static final String NAME_FORMAT = "%" + User.NAME_MAX_LENGTH + "s";

    private ResultView() {
    }

    public static void printLadder(Ladder laddar, List<String> executeResult) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = laddar.getLines();
        for (Line line : lines) {
            addOneLine(sb, line.getPositions());
        }
        sb.append(makeExecuteResultLine(executeResult));
        System.out.println(sb);
    }

    private static void addOneLine(StringBuilder sb, List<Boolean> positions) {
        addBlankLine(sb);
        for (int i = 0; i < positions.size() - 1; i++) {
            boolean hasLine = positions.get(i);
            sb.append(VERTICAL_LINE.makePrintShape(1));
            addHorizontalLine(sb, hasLine);
        }
        sb.append(VERTICAL_LINE.makePrintShape(1)).append("\n");
    }

    public static void printNames(List<User> userNames) {
        System.out.println("\n사다리 결과");
        StringBuilder sb = new StringBuilder();
        userNames.forEach((username) ->
                sb.append(String.format(NAME_FORMAT, username.getName())).append(" ")
        );
        System.out.println(sb);
    }

    public static void printGameResult(User user, GameResults gameResults, List<String> executeResult) {
        System.out.println("\n실행 결과");
        if (user.isSameName("all")) {
            printAllResult(gameResults.getGameResults(), executeResult);
            return ;
        }
        System.out.println(gameResults.getUserResult(user, executeResult));
    }

    private static void printAllResult(List<GameResult> gameResults, List<String> executeResult) {
        for (int i = 0; i < gameResults.size(); i++) {
            GameResult gameResult = gameResults.get(i);
            User user = gameResult.getUser();
            String resultLine = user.getName() + " : " + executeResult.get(gameResult.getResultPosition());
            System.out.println(resultLine);
        }
    }

    private static void printSingleResult(User user, List<GameResult> gameResults, List<String> executeResult) {
        String result = gameResults.stream()
                .filter(gameResult -> gameResult.isSameUser(user))
                .map(GameResult::getResultPosition)
                .map(executeResult::get)
                .findFirst()
                .orElseGet(() -> "[ERROR] 입력된 사람이 사다리게임에 참여하지 않았습니다.");
        System.out.println(result);
    }

    private static String makeExecuteResultLine(List<String> executeResult) {
        StringBuilder sb = new StringBuilder();
        for (String result : executeResult) {
            sb.append(String.format(NAME_FORMAT, result)).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static void addBlankLine(StringBuilder sb) {
        sb.append(BLANK.makePrintShape(User.NAME_MAX_LENGTH));
    }

    private static void addHorizontalLine(StringBuilder sb, boolean hasLine) {
        if (hasLine) {
            sb.append(HORIZONTAL_LINE.makePrintShape(User.NAME_MAX_LENGTH));
            return ;
        }
        addBlankLine(sb);
    }
}
