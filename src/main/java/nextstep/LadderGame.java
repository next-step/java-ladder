package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;
import nextstep.domain.Participant;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String names = createField("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", scanner);
        String prize = createField("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", scanner);
        String height = createField("최대 사다리 높이는 몇 개인가요?", scanner);

        printResult(names, height, prize);

    }

    private static String createField(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static void printNames(List<String> name) {
        name.forEach(item -> {
            System.out.printf(item + " ");
        });
    }

    private static void printLadder(Ladder ladder) {
        List<String> lines = ladder.getLines();
        lines.forEach(item -> System.out.println(item));
    }

    private static void printResult(String names, String height, String prize) {
        List<String> prizeList = createPrizeList(prize);
        Ladder ladder = new Ladder(names, Integer.valueOf(height));
        List<String> name = ladder.getNames();
        printNames(name);
        System.out.println();
        printLadder(ladder);
        printPrize(prizeList);

        System.out.println();
        LadderResult ladderResult = ladder.createLadderResult(prizeList);

        String input = "";
        do {
            System.out.println("결과를 보고 싶은 사람은?");
            input = scanner.nextLine();
            if (Objects.equals(input, "all")) {
                System.out.println("실행 결과");
                ladderResult.getPrizeMappingMap().forEach((key, value) -> System.out.println(key + ": " + value));
                break;
            }

            System.out.println(ladderResult.getPrizeMappingMap().get(input));
        } while (!input.equals("all"));
    }

    private static void printPrize(List<String> prizeList) {
        prizeList.forEach(prize -> {
            System.out.print(prize + "    ");
        });
    }

    private static List<String> createPrizeList(String prize) {
        String[] split = prize.split(",");
        return Arrays.stream(split).collect(Collectors.toUnmodifiableList());
    }
}
