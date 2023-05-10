package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final String EMPTY_LINE = "     |";
    private static final String DRAW_LINE = "-----|";

    public static void printLadder(LadderInputs participants, Ladder ladder, LadderInputs results) {
        printResultMention();
        printInputs(participants);
        printLadderLines(ladder);
        printInputs(results);
    }

    private static void printResultMention() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    private static void printInputs(LadderInputs participants) {
        for (LadderInput ladderInput : participants.getInputs()) {
            System.out.printf("%6s", ladderInput.getLadderInput());
        }
        System.out.println();
    }

    private static void printLadderLines(Ladder ladder) {
        for (Lines lines : ladder.getLadder()) {
            printLines(lines);
            System.out.println();
        }
    }

    private static void printLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(printHasLine(line));
        }
    }

    private static String printHasLine(Line line) {
        if (line.hasLine()) {
            return DRAW_LINE;
        }
        return EMPTY_LINE;
    }

    private static void printRewardMention() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResultAll(Results ladderResults, LadderInputs participants, LadderInputs reward) {
        printRewardMention();
        for (int i = 0; i < participants.countOfInputs(); i++) {
            System.out.println(participants.getInput(i) + " : " + ladderResults.matchResult(i, reward));
        }
    }

    public static void printResult(String matchResult) {
        printRewardMention();
        System.out.println(matchResult);
    }

    public static void printNoName(LadderInput name) {
        System.out.println(name.getLadderInput() + "이라는 이름은 없습니다! 다시 입력해주세요!!");
    }
}
