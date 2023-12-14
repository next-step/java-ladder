package nextstep.ladder.view;

import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {
    private InputView() {
    }

    public static List<Name> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().replace(" ", "").split(",");

        return Arrays.stream(names)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static Results inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String[] stringResults = scanner.nextLine()
                .replace(" ", "")
                .split(",");

        List<Result> results = Arrays.stream(stringResults)
                .map(Result::new)
                .collect(Collectors.toList());

        return new Results(results);
    }

    public static int inputMaxHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Scanner(System.in).nextInt();
    }

    public static Name inputResultPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);

        return new Name(scanner.nextLine());
    }

}
