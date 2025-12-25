package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.user.Users;

import java.util.Map;
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

    public static void printPeopleName() {
        System.out.println(INPUT_PEOPLE_NAME_MESSAGE);
    }

    public static String inputName() {
        return scanner.nextLine();
    }

    public static void printLadderHeight() {
        System.out.println();
        System.out.println(INPUT_LADDER_HIGHT_MESSAGE);
    }

    public static int inputHeight() {
        return scanner.nextInt();
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printLadders(Users users, Ladders ladders) {
        users.getUsers().forEach(user -> System.out.printf("%6s", user.getNameValue()));
        System.out.println();

        Map<Ladder, Boolean> laddersMap = ladders.getLadders();

        IntStream.range(0, ladders.getHeightValue())
                .forEach(i -> {
                    System.out.print(LADDER_START_BLOCK);
                    IntStream.range(0, users.size()).forEach(j -> {
                        System.out.print(laddersMap.get(new Ladder(i, j)) ? LADDER_TRUE : LADDER_FALSE);
                    });
                    System.out.println();
                });
    }
}
