package ladder.ui;

import ladder.domain.Users;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Users inputUser(){
        System.out.println("참여할 사람 이름을 입력하세요.");
        String usersName = scanner.next();
        return new Users(usersName);
    }
}
