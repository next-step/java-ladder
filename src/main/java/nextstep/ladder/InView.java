package nextstep.ladder;

import java.util.Scanner;

public class InView {
    private static final Scanner in = new Scanner(System.in);

    public static String getString() {
        return in.nextLine();
    }

    public static int getInt() {
        int value = in.nextInt();
        in.nextLine();
        return value;
    }
}
