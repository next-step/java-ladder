package ladder.view;

import ladder.dto.*;
import ladder.exception.NanException;
import ladder.view.printable.QuestionPrintable;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RequestView {
    private static final Scanner scanner = new Scanner(System.in);

    private RequestView() {}

    public static PersonsDto askPersons() {
        printQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return nextStrings().stream()
                .map(PersonDto::new)
                .collect(collectingAndThen(toList(), PersonsDto::new));
    }

    public static ResultsDto askResults() {
        printQuestion("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return nextStrings().stream()
                .map(ResultDto::new)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }

    public static LadderHeightDto askLadderHeight() {
        printQuestion("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeightDto(nextInt());
    }

    public static PersonDto askPerson() {
        printQuestion("결과를 보고 싶은 사람은?");
        return new PersonDto(nextLine());
    }

    private static void printQuestion(String question) {
        new QuestionPrintable(System.lineSeparator() + question).print();
    }

    private static String nextLine() {
        return scanner.nextLine();
    }

    private static int nextInt() {
        String numStr = nextLine();
        try {
            return Integer.parseInt(numStr);
        } catch (Exception e) {
            throw NanException.getInstance();
        }
    }

    private static List<String> nextStrings() {
        return Arrays.asList(
                nextLine().split("[ ,]+")
        );
    }
}
