package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static Integer insertInt(){
        return new Scanner(System.in).nextInt();
    }

    public static String insertString(){
        return new Scanner(System.in).nextLine();
    }
}
