package ladder.View;

import ladder.Model.AttendantName;
import ladder.Model.Height;
import ladder.Model.Results;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> TypeAttendances() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String attendances = SCANNER.nextLine();

        try {
            return NameOfAttendant(attendances);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return TypeAttendances();
        }
    }

    public static List<String> NameOfAttendant(String inputString) {
        return Optional.ofNullable(inputString)
                .map(list -> Arrays.stream(inputString.split(","))
                        .map(s -> new AttendantName(s).name())
                        .collect(Collectors.toList()))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Results TypeResult(int width) {
        System.out.println("");
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = SCANNER.nextLine();

        try {
            return new Results(results, width);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return TypeResult(width);
        }
    }

    public static int TypeMaxHeights() {
        System.out.println("");
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputMaxHeights = SCANNER.nextLine();

        try {
            return new Height(inputMaxHeights).height();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return TypeMaxHeights();
        }
    }

}
