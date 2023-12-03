package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String[] inputParticipant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participants = scanner.nextLine();
        return splitBy(participants);
    }

    public String[] inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.nextLine();
        return splitBy(results);
    }

    private String[] splitBy(String participants) {
        return participants.split(",");
    }

    public int inputHighCount() {
        printEmpty();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private void printEmpty() {
        System.out.println("");
    }

    public String inputWantShow() {
        System.out.println("");
        Scanner newScanner = new Scanner(System.in);
        System.out.println("결과를 보고 싶은 사람은?");
        return newScanner.nextLine();
    }
}
