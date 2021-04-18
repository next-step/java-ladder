package step2.view;


import step2.domain.Ladder;
import step2.domain.Users;

public class OutputView {

    public static void printResult(Users users, Ladder ladder) {
        System.out.println(Message.RESULT);
        System.out.println(users);
        System.out.println(ladder);
    }
}
