package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public Integer insertInt() {
        return new Scanner(System.in).nextInt();
    }

    public String insertString() {
        return new Scanner(System.in).nextLine();
    }

    public List<String> insertStrings() {
        String str = new Scanner(System.in).nextLine();
        return Arrays.stream(str.split(",")).collect(Collectors.toList());
    }
}
