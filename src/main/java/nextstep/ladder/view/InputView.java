package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.*;
import nextstep.ladder.domain.user.Users;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static final String INPUT_PEOPLE_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_REWARD_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_PRINT_PEOPLE = "결과를 보고 싶은 사람은?";
    public static final String LADDER_RESULT_MESSAGE = "[사다리 결과]";
    public static final String RESULT_MESSAGE = "[실행결과]";
    public static final String LADDER_TRUE = "|-----";
    public static final String LADDER_FALSE = "|     ";
    public static final String LADDER_START_BLOCK = "     ";
    public static final String NEXT_LINE = System.lineSeparator();


    public static Users inputName() {
        printMessageNextLine(INPUT_PEOPLE_NAME_MESSAGE);
        return new Users(scanner.nextLine());
    }

    public static Rewards inputReward() {
        printMessageNextLine(INPUT_REWARD_MESSAGE);
        return new Rewards(scanner.nextLine());
    }

    public static Height inputHeight() {
        printMessageNextLine("");
        printMessageNextLine(INPUT_LADDER_HIGHT_MESSAGE);
        return new Height(scanner.nextInt());
    }

    public static void printResultMessage() {
        printMessageNextLine("");
        printMessageNextLine(LADDER_RESULT_MESSAGE + NEXT_LINE);
    }

    public static void printLadders(LadderGame ladderGame) {
        printUserNames(ladderGame.getUsers());
        printLines(ladderGame.getLines());
        printRewards(ladderGame.getRewards());
        printMessageNextLine("");
    }

    public static void printResultPeople() {
        printMessageNextLine(RESULT_PRINT_PEOPLE);
    }

    public static String inputResultPeople() {
        return scanner.next();
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

    private static void printRewards(Rewards rewards) {
        rewards.getRewards().forEach(reward -> System.out.printf("%6s", reward.getReward()));
        printMessageNextLine("");
    }

    private static void printSingleLine(Line line) {
        IntStream.range(0, line.size())
                .forEach(j -> printMessageCurrentLine(line.getLines().get(j) ? LADDER_TRUE : LADDER_FALSE));
    }

    private static void printMessageCurrentLine(String message) {
        System.out.print(message);
    }

    private static void printMessageNextLine(String message) {
        System.out.println(message);
    }
}
