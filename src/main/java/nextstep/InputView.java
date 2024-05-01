package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static LadderResult createLadderResult() {
        String names = createField("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", scanner);
        String prize = createField("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", scanner);
        String height = createField("최대 사다리 높이는 몇 개인가요?", scanner);
        Ladder ladder = new Ladder(names, Integer.valueOf(height));
        return ladder.createLadderResult(createPrizeList());
    }

    private static String createField(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static List<String> createPrizeList() {
        String prize = createField();
        String[] split = prize.split(",");
        return Arrays.stream(split).collect(Collectors.toUnmodifiableList());
    }

    public static String createField() {
        return scanner.nextLine();
    }
}
