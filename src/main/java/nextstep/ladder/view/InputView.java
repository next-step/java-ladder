package nextstep.ladder.view;

import nextstep.ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Person> getPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Person::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
