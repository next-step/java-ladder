package nextstep.ladder.view;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private static final String INPUT_USER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAXIMUM_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요";

    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SHOW_USER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?(전체:ALL, 종료:STOP)";

    public static final String ALL = "all";
    public static final String STOP = "stop";

    public static String[] inputUserName(){
        System.out.println(INPUT_USER_NAME_MESSAGE);
        String input = SCANNER.nextLine();
        System.out.println();
        return input.split(SEPARATOR);
    }

    public static int inputMaximumLadderHeight(){
        System.out.println(INPUT_MAXIMUM_LADDER_HEIGHT_MESSAGE);
        int height = SCANNER.nextInt();
        System.out.println();
        return height;
    }

    public static List<String> inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        String input = SCANNER.nextLine();
        System.out.println();
        return Stream.of(input.split(SEPARATOR)).collect(Collectors.toList());
    }

    public static String inputUserForResult() {
        System.out.println(INPUT_SHOW_USER_RESULT_MESSAGE);
        String userName = SCANNER.nextLine();
        System.out.println();
        return userName;
    }
}
