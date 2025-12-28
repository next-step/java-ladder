package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Lines;
import nextstep.ladder.domain.user.Users;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static final String INPUT_PEOPLE_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_MESSAGE = "[실행결과]";
    public static final String LADDER_TRUE = "|-----";
    public static final String LADDER_FALSE = "|     ";
    public static final String LADDER_START_BLOCK = "     ";
    public static final String NEXT_LINE = System.lineSeparator();

    public static void printPeopleName() {
        printMessageNextLine(INPUT_PEOPLE_NAME_MESSAGE);
    }

    public static Users inputName() {
        return new Users(scanner.nextLine());
    }

    public static void printLadderHeight() {
        printMessageNextLine("");
        printMessageNextLine(INPUT_LADDER_HIGHT_MESSAGE);
    }

    public static Height inputHeight() {
        return new Height(scanner.nextInt());
    }

    public static void printResultMessage() {
        printMessageNextLine("");
        printMessageNextLine(RESULT_MESSAGE + NEXT_LINE);
    }

    public static void printLadders(LadderGame ladderGame) {
        printUserNames(ladderGame.getUsers());

        printLines(ladderGame.getLines());
    }

    private static void printUserNames(Users users) {
        users.getUsers().forEach(user -> System.out.printf("%6s", user.getNameValue()));
        printMessageNextLine("");
    }

    private static void printLines(Lines lines) {
        IntStream.range(0, lines.size())
                .forEach(i -> {
                    printMessageCurrentLine(LADDER_START_BLOCK);
                    printSingleLine(lines.getLines().get(i));
                    printMessageCurrentLine(LADDER_FALSE);
                    printMessageNextLine("");
                });
    }

    private static void printSingleLine(Line line) {
        IntStream.range(0, line.size())
                .forEach(j -> printMessageCurrentLine(line.getLine().get(j) ? LADDER_TRUE : LADDER_FALSE));
    }

    private static void printMessageCurrentLine(String message) {
        System.out.print(message);
    }

    private static void printMessageNextLine(String message) {
        System.out.println(message);
    }
}
