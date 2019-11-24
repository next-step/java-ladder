package nextstep.ladder.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-12 16:15
 */
public class LadderInputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final int MINIMUM_MAXIMUM_VALUE = 5;

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = StringUtils.deleteWhitespace(SCANNER.nextLine());
        return arrayToList(inputNames.split(","), "이름은 다섯글자 이하로 입력해주세요.");
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = SCANNER.nextLine();
        if (!isNumeric(inputHeight)) {
            throw new InputMismatchException("숫자만 입력해주세요");
        }

        return Integer.parseInt(inputHeight);
    }

    public static List<String> inputExecuteResult(int personCount) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] inputResult = StringUtils.deleteWhitespace(SCANNER.nextLine()).split(",");

        if (inputResult.length != personCount) {
            throw new InputMismatchException("참여하는 인원과 결과의 수는 같아야합니다.");
        }

        return arrayToList(inputResult, "결과는 다섯글자 이하로 입력해주세요.");
    }

    public static String inputSeeResult(List<String> names) {
        System.out.println("결과를 보고 싶은 사람은?");
        String inputName = StringUtils.deleteWhitespace(SCANNER.nextLine());
        if (!removeBlankList(names).contains(inputName) && !"all".equals(inputName)) {
            throw new InputMismatchException("사다리 게임에 참여하지 않은 사용자입니다.");
        }

        return inputName;
    }

    private static List<String> removeBlankList(List<String> names) {
        return names.stream().map(StringUtils::deleteWhitespace).collect(Collectors.toList());
    }

    private static List<String> arrayToList(String[] inputResult, String exceptionMessage) {
        return Arrays
                .stream(inputResult)
                .map(input -> {
                    if (input.length() > MINIMUM_MAXIMUM_VALUE) {
                        throw new InputMismatchException(exceptionMessage);
                    }
                    return input;
                })
                .collect(Collectors.toList());
    }

    private static boolean isNumeric(String inputHeight) {
        return NUMERIC.matcher(inputHeight).matches();
    }
}
