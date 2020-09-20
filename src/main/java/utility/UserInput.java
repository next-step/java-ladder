package utility;

import domain.UserName;
import nextstep.optional.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static view.View.*;

public class UserInput {
    public static Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static List<UserName> inputUserNames() {
        System.out.println(NAMES);
        String input = SC.nextLine();
        String users[] = input.split(",");

        List<UserName> list = new ArrayList<>();

        for (String userName : users) {
            list.add(new UserName(userName));
        }
        return list;
    }

    public static int inputHeight() {
        System.out.println(HEIGHT);
        int height = SC.nextInt();
        SC.nextLine();

        System.out.println(RESULT_LADDER);
        return height;
    }

    public static String inputResult() {
        System.out.println(RESULT_INPUT);
        String input = SC.nextLine();
        return input;
    }

    public static String wantToSeeName() {
        System.out.println(RESULT_WANT);
        String input = SC.nextLine();

        return input;
    }
}
