package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGoalBoard;

import java.util.Scanner;

public class LadderGoalInputView {

    private final static String LADDER_GOAL_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public static LadderGoalBoard enter() {
        System.out.println(LADDER_GOAL_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        return new LadderGoalBoard(next);
    }

}
