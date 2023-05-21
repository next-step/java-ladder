package ladder.View;

import ladder.Model.AttendantName;
import ladder.Model.Height;
import ladder.Model.ResultMap;
import ladder.Model.Results;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final int RETURN_NORMAL_STATUS = 0;
    private static final String COMMAND_PRINT_ALL = "all";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> typeAttendances() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String attendances = SCANNER.nextLine();

        try {
            return nameOfAttendant(attendances);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return typeAttendances();
        }
    }

    public static List<String> nameOfAttendant(String inputString) {
        return Optional.ofNullable(inputString)
                .map(list -> Arrays.stream(inputString.split(","))
                        .map(s -> new AttendantName(s).name())
                        .collect(Collectors.toList()))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Results typeResult(int width) {
        System.out.println("");
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = SCANNER.nextLine();

        try {
            return new Results(results, width);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return typeResult(width);
        }
    }

    public static int typeMaxHeights() {
        System.out.println("");
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputMaxHeights = SCANNER.nextLine();

        try {
            return new Height(inputMaxHeights).height();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return typeMaxHeights();
        }
    }

    public static int typeLadderResult(ResultMap resultMap, Results results) {
        System.out.println("결과를 보고 싶은 사람은?");
        String resultMapKey = SCANNER.nextLine();
        if (resultMapKey.equals(COMMAND_PRINT_ALL)) {
            return printAllResult(resultMap, results);
        }

        if (!resultMap.of().containsKey(resultMapKey)) {
            System.out.println("다시 입력해주세요.(참여자가 아닙니다)");
            return typeLadderResult(resultMap, results);
        }

        printFoundResult(results, resultMap.get(resultMapKey));
        return typeLadderResult(resultMap, results);
    }

    private static int printAllResult(ResultMap resultMap, Results results) {
        System.out.println("");
        System.out.println("실행 결과");
        resultMap.of().forEach(
                (k,v) -> {
                    System.out.println(k + " : " + results.get(v));
                }
        );
        System.out.println("");

        return RETURN_NORMAL_STATUS;
    }

    private static void printFoundResult(Results results, int key) {
        System.out.println("");
        System.out.println("실행 결과");
        System.out.println(results.get(key));
        System.out.println("");
    }

}
