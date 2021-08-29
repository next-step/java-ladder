package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.LadderHeight;
import nextstep.ladder.domain.player.Name;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reword.Rewords;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static LadderHeight inputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        return LadderHeight.of(height);
    }

    public static Players inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);

        return Players.from(Arrays.stream(scanner.next().split(","))
            .map(Name::of)
            .collect(Collectors.toList()));
    }

    public static Rewords inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세욘)");
        Scanner scanner = new Scanner(System.in);
        return Rewords.from(Arrays.stream(scanner.next().split(","))
            .collect(Collectors.toList()));
    }

    public static String inputNameOfPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
