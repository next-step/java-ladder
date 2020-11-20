package ladder.view;

import ladder.dto.request.LadderHeightDto;
import ladder.dto.request.PersonsDto;
import ladder.exception.NanException;
import ladder.view.printable.QuestionPrintable;

import java.util.Arrays;
import java.util.Scanner;

public class RequestView {
    private static final Scanner scanner = new Scanner(System.in);

    private RequestView() {}

    public static PersonsDto askPersons() {
        printQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new PersonsDto(Arrays.asList(
                nextLine().split("[ ,]+")
        ));
    }

    public static LadderHeightDto askLadderHeight() {
        printQuestion("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeightDto(nextInt());
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
}
