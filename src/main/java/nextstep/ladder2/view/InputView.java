package nextstep.ladder2.view;

import nextstep.ladder2.ErrorMessage;

import java.util.Scanner;

public class InputView {

    public static String getName(Scanner sc) {
        String question = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        return inputValue(sc, question, false);
    }

    public static String getResults(Scanner sc) {
        String question = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        return inputValue(sc, question, false);
    }

    public static int getHeight(Scanner sc) {
        String question = "최대 사다리 높이는 몇 개인가요?";
        return Integer.valueOf(inputValue(sc, question, true));
    }

    public static String inputName(Scanner sc) {
        String question = "결과를 보고 싶은 사람은? ('all' 입력시 전체조회후 종료)";
        return inputValue(sc, question, false);
    }

    public static String inputValue(Scanner sc, String question, boolean isNumberInput) {
        String result = "";
        while (true) {
            try {
                System.out.println(question);
                result = sc.nextLine();
                if (isNumberInput) {
                    checkInputNumber(result);
                } else {
                    checkInput(result);
                }
                break;
            } catch (NumberFormatException ne) {
                System.out.println(ErrorMessage.IS_NOT_NUMBER.message());
                continue;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        return result;
    }

    private static void checkInputNumber(String input) throws Exception {
        if ("0".equals(input)) {
            throw new Exception(ErrorMessage.ZERO_HEIGHT.message());
        }
        Integer.valueOf(input);
    }

    private static void checkInput(String input) throws Exception {
        if ("".equals(input)) {
            throw new Exception(ErrorMessage.IS_BLANK.message());
        }
    }

}
