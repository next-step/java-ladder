package step1.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static List<String> initJoinUserNames() {
        PrintView.printInitJoinUserNamesPhrase();
        String split = scanner().next();
        return Arrays.stream(split.split(",")).collect(Collectors.toList());
    }

    public static int initLadderHeight() {
        PrintView.printInitLadderHeightPhrase();
        return scanner().nextInt();
    }
}
