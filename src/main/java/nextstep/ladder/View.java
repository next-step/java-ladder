package nextstep.ladder;

import java.util.Scanner;

public class View {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Names getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Names.of(SCANNER.nextLine());
    }

    public static LadderHeight getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        LadderHeight height = LadderHeight.of(SCANNER.nextInt());
        SCANNER.nextLine(); // consume the newline character
        return height;
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("실행 결과");
        ladder.getNames()
                .getListNames()
                .forEach(name -> System.out.printf("%5s ", name.get()));
        System.out.println();
        ladder.getLines()
                .getListLines()
                .forEach(line -> {
                    printLine(line);
                    System.out.println();
                });
    }

    private static void printLine(Line line) {
        line.getPoints()
                .forEach(point -> {
                    if (point == Point.LEFT) {
                        System.out.print("-----|");
                        return;
                    }
                    System.out.print("     |");
                });
    }
}
