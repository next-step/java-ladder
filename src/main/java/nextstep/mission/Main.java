package nextstep.mission;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Participant> participants = InputScanner.printMessageAndGetUsers("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println();

        int height = InputScanner.printMessageAndGetHeight("최대 사다리 높이는 몇 개인가요?");
        System.out.println();

        Ladder ladder = Ladder.make(new Participants(participants), height);
        System.out.println("실행 결과");

        ResultViewer.showResult(participants, ladder);
    }
}
