package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static Integer insertInt(){
        return new Scanner(System.in).nextInt();
    }

    public static String insertString(){
        return new Scanner(System.in).nextLine();
    }
}
