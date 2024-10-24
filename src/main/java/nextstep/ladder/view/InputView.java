package nextstep.ladder.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    static Scanner SC = new Scanner(System.in);

    public static List<String> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> players = Arrays.stream(SC.nextLine().replaceAll(" ", "").split(","))
                .collect(Collectors.toList());
        checkDuplicateInputs(players);

        return players;
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SC.nextLine());
    }

    public static List<String> inputPrizes() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> prizes = Arrays.stream(SC.nextLine().replaceAll(" ", "").split(","))
                .collect(Collectors.toList());
        checkDuplicateInputs(prizes);

        return prizes;
    }

    public static void checkDuplicateInputs(List<String> inputs) {
        Set<String> set = new HashSet<>(inputs);
        if (set.size() != inputs.size()) {
            throw new IllegalArgumentException("duplicate players error");
        }
    }

    public static String inputPlayerForResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return SC.nextLine();
    }
}
