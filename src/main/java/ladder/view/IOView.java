package ladder.view;

import ladder.domain.Ladders;

import java.util.List;
import java.util.Scanner;

import static ladder.util.StringUtil.split;

public class IOView {
    private static final Scanner sc = new Scanner(System.in);
    private IOView() {}

    public static String[] inputPlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return split(sc.nextLine());
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public static void printName(List<String> names) {
        StringBuilder sb = new StringBuilder();
        names.forEach(name -> sb.append(String.format(" %5s", name)));
        System.out.println(sb);
    }

    public static void printLadders(Ladders ladders) {
        ladders.getLadders().forEach(ladder -> System.out.println(ladder.ladderDraw()));
    }
}
