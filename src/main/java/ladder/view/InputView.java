package ladder.view;

import ladder.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public List<Name> requestName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public int requestHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
