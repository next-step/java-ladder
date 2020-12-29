package nextstep.ladder.ui;

import nextstep.ladder.domain.Height;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String PROMPT_GET_NAMES_OF_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,) 로 구분하세요)";
    private static final String PROMPT_GET_TITLES_OF_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PROMPT_GET_HEIGHT = "최대 사다리 높이는 몇 개인가요?";


    public static List<String> getNamesOfMembers() {
        System.out.println(PROMPT_GET_NAMES_OF_MEMBERS);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> getTitlesOfResults() {
        System.out.println(PROMPT_GET_TITLES_OF_RESULTS);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static Height getHeight() {
        System.out.println(PROMPT_GET_HEIGHT);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        return new Height(Integer.parseInt(input));
    }

}
