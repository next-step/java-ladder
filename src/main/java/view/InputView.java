package view;

import util.Console;
import util.ErrorMessage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static String inputPalyer() {
        Console.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static int inputLadderHeight() {
        Console.print("최대 사다리 높이는 몇 개인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }
}
