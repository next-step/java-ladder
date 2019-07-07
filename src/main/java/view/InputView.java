package view;

import java.util.Scanner;

public class InputView {

    public static String inputUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputGoals() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행할 사다리의 난이도는?");
        return scanner.nextLine();
    }

    public static String inputResultUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
