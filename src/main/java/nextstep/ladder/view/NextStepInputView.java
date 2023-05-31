package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NextStepInputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static List<String> getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participants = scanner.next();
        return separateToList(participants);
    }
    
    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.next();
        return separateToList(results);
    }

    private static List<String> separateToList(String results) {
        return Arrays.stream(results.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static String getNameOrCodeForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
