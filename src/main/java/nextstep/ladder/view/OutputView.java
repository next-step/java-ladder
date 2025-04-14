package nextstep.ladder.view;

import nextstep.ladder.dto.LadderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final int NAME_MIN_WIDTH = 5;
    private static final int LADDER_WIDTH = 5;

    public static void showLadderResult(LadderDto ladderDto) {
        System.out.printf("실행 결과%n%n");
        System.out.println(toConfigConsoleFormat(ladderDto.getLadderUsers()));
        System.out.println(toLadderConsoleFormat(ladderDto.getLadder()));
        System.out.println(toConfigConsoleFormat(ladderDto.getLadderPrizes()));
    }

    public static void showLadderUserResult(LadderDto ladderDto) {
        String name = "";
        while (!name.equals("all")) {
            name = InputView.showLadderResultUser();
            System.out.println("실행 결과");
            System.out.printf("%s%n%n", ladderDto.getPrizeResult().get(name));
        }

        System.out.println("실행 결과");
        ladderDto.getPrizeResult().forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static String toConfigConsoleFormat(List<String> values) {
        return values.stream()
            .map(OutputView::toNameConsoleFormat)
            .collect(Collectors.joining(" ", "", ""));
    }

    private static String toNameConsoleFormat(String name) {
        if (name.length() >= NAME_MIN_WIDTH) {
            return name;
        }
        int leftPadding = (NAME_MIN_WIDTH - name.length()) / 2;
        int rightPadding = NAME_MIN_WIDTH - name.length() - leftPadding;
        return " ".repeat(leftPadding) + name + " ".repeat(rightPadding);
    }

    private static String toLadderConsoleFormat(List<List<Boolean>> ladder) {
        return ladder.stream()
            .map(OutputView::toLadderLineConsoleFormat)
            .collect(Collectors.joining("\n"));
    }

    private static String toLadderLineConsoleFormat(List<Boolean> line) {
        return line.stream()
            .map(point -> point ? "|" + "-".repeat(LADDER_WIDTH) : "|" + " ".repeat(LADDER_WIDTH))
            .collect(Collectors.joining("", "  ", "|"));
    }
}
