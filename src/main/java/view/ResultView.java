package view;

import domain.ladder.Ladder;
import domain.user.Users;

public class ResultView {
    public static void result(Users users, Ladder ladder) {
        System.out.println(users.toString());
        System.out.println(ladder.toString(users.margin()));
    }
}
