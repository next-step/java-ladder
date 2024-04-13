package nextstep.ladder.view;

import nextstep.ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Person> getPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException(String.format("참가자의 이름은 (%s)와 같이 공백이거나 null일 수 없습니다.", line));
        }
        String[] names = line.split(",");
        return IntStream.range(0, names.length)
                .mapToObj(index -> new Person(names[index], index))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<String> getResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException(String.format("참가자의 이름은 (%s)와 같이 공백이거나 null일 수 없습니다.", line));
        }
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String getPersonName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    public static void getNextLine() {
        scanner.nextLine();
    }
}
