package nextstep.ladder.view;

import nextstep.ladder.Position;
import nextstep.ladder.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InputView {

    public static String[] inputName(Scanner scanner) {
        boolean flag = true;
        String[] participants = null;
        while (flag) {
            try {
                participants = makeParticipants(scanner);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return participants;
    }

    public static int makeDepth(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int depth = Integer.valueOf(scanner.nextLine());

        return depth;
    }

    private static String[] makeParticipants(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] names = scanner.nextLine().split(",");

        return names;
    }

    public static String getName(Scanner scanner) {
        System.out.println("찾을사람:");
        return scanner.nextLine();
    }

    public static List<Result> inputResult(Scanner scanner) {
        System.out.println("당첨상품 입력:");
        String[] resultValue = scanner.next().split(",");
        AtomicInteger initPosition = new AtomicInteger();
        return Arrays.stream(resultValue)
                .map(name -> Result.of(name, new Position(initPosition.getAndIncrement(), resultValue.length)))
                .collect(Collectors.toList());
    }
}
