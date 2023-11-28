package nextstep.ladder.view;

public class OutputView {

    public void printResult() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        printParticipators();
        printLadder();
    }

    private void printParticipators() {
        System.out.println("사람 이름을 출력하도록 변경합니다.");
    }

    private void printLadder() {
        System.out.println("사다리를 출력하도록 변경합니다.");
    }
}
