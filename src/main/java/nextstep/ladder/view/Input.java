package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.LadderResult;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    private static final String PARTICIPATION_INPUT_FOR_RESULT = "결과를 보고 싶은 사람은?";
    private static final String PARTICIPATION_USERNAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";
    private static final String BLANK = " ";
    private static final String NOT_BLANK = "";
    private static final Scanner scanner = new Scanner(System.in);

    public static String readCommandForResult(){
        System.out.println(PARTICIPATION_INPUT_FOR_RESULT);
        return scanner.nextLine();
    }

    public static List<Player> readPlayerNames(){
        System.out.println(PARTICIPATION_USERNAMES);
        String input = scanner.nextLine();
        input = input.replaceAll(BLANK,NOT_BLANK);
        return Stream.of(input.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static List<LadderResult> readResults(){
        System.out.println(LADDER_RESULT);
        String input = scanner.nextLine();
        input = input.replaceAll(BLANK,NOT_BLANK);
        return Stream.of(input.split(DELIMITER))
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public static int readMaxLadderLength(){
        System.out.println(MAX_LADDER_LENGTH);
        return Integer.parseInt(scanner.nextLine());
    }
}
