package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OutView {
    private LadderResult ladderResult;
    private static final Scanner scanner = new Scanner(System.in);

    public OutView(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public void createStartResultView() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public boolean createResultView(String input) {
        if (Objects.equals(input, "all")) {
            System.out.println("실행 결과");
            ladderResult.getPrizeMappingMap().forEach((key, value) -> System.out.println(key + ": " + value));
            return true;
        }

        System.out.println(ladderResult.getPrizeMappingMap().get(input));
        return false;
    }

    public static void createLadderResultView(Ladder ladder, List<String> prizeList) {
        System.out.println("사다리 결과");
        printNames(ladder.getNames());
        System.out.println();
        printLadder(ladder);
        printPrize(prizeList);

        System.out.println();
        LadderResult ladderResult = ladder.createLadderResult(prizeList);
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

    private static void printPrize(List<String> prizeList) {
        prizeList.forEach(prize -> {
            System.out.print(prize + "    ");
        });
    }

    public static void createParticipantsView() {
        createField("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void createPrizeView() {
        createField("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void createHeightView() {
        createField("최대 사다리 높이는 몇 개인가요?");
    }

    private static void createField(String message) {
        System.out.println(message);
    }
}
