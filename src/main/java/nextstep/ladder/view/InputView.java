package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static Scanner scanner = new Scanner(System.in);

    public static String inputString(){
        return scanner.nextLine();
    }

    public static Integer inputInt(){
        return scanner.nextInt();
    }
}
