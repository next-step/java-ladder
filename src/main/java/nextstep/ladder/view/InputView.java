package nextstep.ladder.view;

import nextstep.ladder.dto.LadderRequestDto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static LadderRequestDto inputParameters() {
        String names = inputNames();
        int height = inputHeight();
        String results = inputResults();
        return new LadderRequestDto(names, height, results);
    }

    private static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.next();
    }
}
