package step2.view;


import static step2.view.Message.PRIZE_RESULT;
import static step2.view.ViewConstants.NEW_LINE;

import java.util.stream.Collectors;
import step2.domain.Ladder;
import step2.domain.LadderType;
import step2.domain.Prize;
import step2.domain.Prizes;
import step2.domain.Result;
import step2.domain.User;
import step2.domain.Users;

public class OutputView {

    public static void printResult() {
        System.out.println(Message.LADDER_RESULT);
    }

    public static void printUsers(Users users) {
        String userToString = users.value().stream()
            .map(User::name)
            .map(name -> String.format("%6s", name.value()))
            .collect(Collectors.joining());
        System.out.println(userToString);
    }

    public static void printLadder(Ladder ladder) {
        String ladderToString = ladder.value().stream()
            .map(line -> line.points().stream()
                .map(LadderType::ladder)
                .collect(Collectors.joining()))
            .collect(Collectors.joining(NEW_LINE));
        System.out.println(ladderToString);
    }

    public static void printPrizes(Prizes prizes) {
        String prizeToString = prizes.value().stream()
            .map(Prize::product)
            .map(product -> String.format("%6s", product.value()))
            .collect(Collectors.joining());
        System.out.println(prizeToString);
    }

    public static void printPrize(Prize prize) {
        System.out.println();
        System.out.println(PRIZE_RESULT);
        System.out.println(prize.product().value());
    }

    public static void printAll(Result result, Users users) {
        System.out.println(PRIZE_RESULT);
        users.value()
            .forEach(user -> {
                Prize prize = result.prize(user);
                System.out.println(
                    String.format("%s : %s", user.name().value(), prize.product().value()));
            });
    }
}
