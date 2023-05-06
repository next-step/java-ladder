package nextstep.ladder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static List<PersonName> getPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        return List.of(scanner.nextLine()
                              .split(","))
                   .stream()
                   .map(PersonName::new)
                   .collect(Collectors.toList());
    }

    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
