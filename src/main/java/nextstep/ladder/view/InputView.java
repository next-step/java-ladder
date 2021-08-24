package nextstep.ladder.view;

import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Persons;
import java.util.Arrays;
import java.util.List;
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

    public static Persons inputPersons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);

        return Persons.of(Arrays.stream(scanner.next().split(","))
            .map(Person::of)
            .collect(Collectors.toList()));
    }

    public static List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세욘)");
        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.next().split(","))
            .collect(Collectors.toList());
    }

    public static String inputWantPerson() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
