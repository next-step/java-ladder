package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGameUser;
import nextstep.ladder.domain.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USERNAME_DELIMITER = ",";

    private InputView() {
    }

    public static List<LadderGameUser> askParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputUserNames = SCANNER.nextLine().split(USERNAME_DELIMITER);

        List<LadderGameUser> ladderGameUsers = new ArrayList<>();
        Order order = Order.FIRST_ORDER;

        for (String userName : inputUserNames) {
            ladderGameUsers.add(new LadderGameUser(order, userName));
            order = order.next();
        }

        return Collections.unmodifiableList(ladderGameUsers);
    }

    public static int askMaximumLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }
}

