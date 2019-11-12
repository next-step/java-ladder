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
    private static final String BLANK = " ";

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = SCANNER.nextLine();
        return Arrays
                .stream(inputNames.split(","))
                .map(name -> {
                    if (name.length() > MINIMUM_MAXIMUM_VALUE) {
                        throw new InputMismatchException("이름은 다섯글자 이하로 입력해주세요.");
                    }
                    return paddingBlank(name);
                })
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = SCANNER.nextLine();
        if (!isNumeric(inputHeight)) {
            throw new InputMismatchException("숫자만 입력해주세요");
        }

        return Integer.parseInt(inputHeight);
    }

    private static boolean isNumeric(String inputHeight) {
        return NUMERIC.matcher(inputHeight).matches();
    }

    private static String paddingBlank(String name) {
        return StringUtils.rightPad(name, MINIMUM_MAXIMUM_VALUE, BLANK);
    }
}
