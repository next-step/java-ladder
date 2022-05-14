package nextstep.ladder.view;

import nextstep.ladder.domain.Members;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Members inputMemberNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            String userNames = SCANNER.nextLine();
            return new Members(userNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return inputMemberNames();
    }

}
