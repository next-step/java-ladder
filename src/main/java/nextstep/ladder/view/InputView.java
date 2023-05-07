package nextstep.ladder.view;

import nextstep.ladder.domain.Member;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_REGEX = ",";

    public static Members members() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return new Members(Arrays.stream(names.split(DEFAULT_REGEX)).map(Member::new).collect(Collectors.toList()));
    }

    public static Result result(int countOfMember) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();

        List<String> results = Arrays.stream(names.split(DEFAULT_REGEX)).collect(Collectors.toList());
        if (countOfMember != results.size()) {
            throw new IllegalArgumentException("참여 사람목록과, 실행결과의 숫자가 맞지 않습니다.");
        }

        return new Result(results);
    }

    public static int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String match() {
        System.out.println("결과를 보고 싶은 사람은?");
        scanner.nextLine();
        return scanner.nextLine();
    }
}
