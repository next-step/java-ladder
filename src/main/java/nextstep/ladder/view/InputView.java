package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PARTICIPANT_MESSAGE =
            "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static List<String> getParticipant() {
        System.out.println(PARTICIPANT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int getHeight() {
        System.out.println(HEIGHT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private InputView() {
    }
}
