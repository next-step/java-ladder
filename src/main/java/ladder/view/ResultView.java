package ladder.view;

import ladder.domain.*;
import ladder.dto.GameResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String ROW = "-----";
    public static final String EMPTY_ROW = "     ";
    public static final String COLUMN = "|";
    public static final String SIX_LENGTH_FORMAT = "%6s";
    public static final String RESULT_ALL = "all";
    public static final String EXIT = "exit";

    public static void printLadderInfoMessage() {
        System.out.println("사다리 결과");
        System.out.println();
    }
    public static void printResultInfoMessage() {
        System.out.println("실행 결과");
    }

    public static void printUsers(Users users) {
        String userNames = users.users().stream()
                .map(user -> String.format(SIX_LENGTH_FORMAT, user.name()))
                .collect(Collectors.joining());

        System.out.println(userNames);
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        String row = line.points().stream()
                .map(ResultView::printRowAtEachPoint)
                .collect(Collectors.joining(COLUMN));

        System.out.println(row + COLUMN);
    }

    private static String printRowAtEachPoint(Point point) {
        if (point.canMoveToLeft()) {
            return ROW;
        }
        return EMPTY_ROW;
    }

    public static void printLadderGameResult(GameResult gameResult) {
        String results = gameResult.gameResult().stream()
                .map(result -> String.format(SIX_LENGTH_FORMAT, result))
                .collect(Collectors.joining());

        System.out.println(results);
    }

    public static void printGamesResult(List<GameResultDto> gameResultDtoList) {
        while (true) {
            String userName = InputView.inputNameForGetResult();
            if (EXIT.equals(userName)) {
                return;
            }

            printResultInfoMessage();
            if (RESULT_ALL.equals(userName)) {
                printAllResult(gameResultDtoList);
                System.out.println();
                continue;
            }

            gameResultDtoList.stream()
                    .filter(gameResultDto -> userName.equals(gameResultDto.getName()))
                    .findFirst()
                    .ifPresentOrElse(
                            gameResultDto -> System.out.println(gameResultDto.getResult()),
                            () -> System.out.println("다시 입력해 주세요.")
                    );
            System.out.println();
        }
    }

    private static void printAllResult(List<GameResultDto> gameResultDtoList) {
        gameResultDtoList.forEach(result -> {
            System.out.println(result.getName() + " : " + result.getResult());
        });
    }
}
