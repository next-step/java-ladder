package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public String getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println("이름이 알파벳이나 숫자가 아닐 경우 프로그램을 실행하지 않습니다");
        return scanner.nextLine();
    }

    public int getMaximumLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String getNameQuery() {
        System.out.println("결과를 보고 싶은 사람은?");
        System.out.println("모든 사람들의 결과를 보기 위해서는 @all을 입력해주세요");
        System.out.println("프로그램을 종료하기 위해서는 @quit를 입력해주세요");
        return scanner.nextLine();
    }
}
