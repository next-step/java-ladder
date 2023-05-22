package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class OutputView {

    public static void display(Users users, Ladder ladder, LadderResults ladderResults) {
        System.out.println("사다리 결과\n");
        System.out.println(users.status());
        System.out.println(ladder.status());
        System.out.println(ladderResults.status());
    }


    public static void announceAllUsers(List<User> usersAfter, LadderResults ladderResults) {
        System.out.println("실행 결과");
        usersAfter.forEach(user -> System.out.println(user.getName() + " : " + ladderResults.getLadderResultList().get(user.getPosition()).getResult()));
    }

    public static void announceUser(String name, List<User> usersAfter, LadderResults ladderResults) {
        System.out.println("실행 결과");
        usersAfter.stream()
                .filter(user -> user.getName().equals(name))
                .forEach(user -> System.out.println(user.getName() + " : " + ladderResults.getLadderResultList().get(user.getPosition()).getResult()));
    }
}
