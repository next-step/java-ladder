package me.namuhuchutong.ladder.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final static Scanner INPUT = new Scanner(System.in);

    public String inputStringNames() {
        printMessage("참가자의 이름을 입력하세요.");
        return INPUT.nextLine();
    }

    public int inputInteger() {
        printMessage("사다리의 높이를 입력하세요.");
        return inputIntegerFromStandardInput();
    }

    private int inputIntegerFromStandardInput() {
        try {
            return INPUT.nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
