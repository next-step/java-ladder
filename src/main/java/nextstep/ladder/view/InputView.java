package nextstep.ladder.view;

import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MEMBER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static Members inputMemberNames() {
        System.out.println(INPUT_MEMBER_NAMES_MESSAGE);

        try {
            String userNames = SCANNER.nextLine();
            return new Members(userNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return inputMemberNames();
    }

    public static MaxHeightOfLadder inputMaxHeightOfLadder() {
        System.out.println(INPUT_MAX_HEIGHT_OF_LADDER_MESSAGE);

        try {
            String string = SCANNER.nextLine();
            return new MaxHeightOfLadder(string);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return inputMaxHeightOfLadder();
    }

}
