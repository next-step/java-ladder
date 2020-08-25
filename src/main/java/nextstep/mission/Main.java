package nextstep.mission;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Participant> participants = InputScanner.printMessageAndGetUsers("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println();

        int height = InputScanner.printMessageAndGetHeight("최대 사다리 높이는 몇 개인가요?");
        System.out.println();

        Ladder make = Ladder.make(participants, height);
        System.out.println("실행 결과");

        participants.stream()
                .forEach(participant -> System.out.printf("%6s", participant));

        System.out.printf("\n");
        while (make.hasNext()) {
            System.out.println(ResultViewer.lineToWrite(make.getLine()));
        }
    }
}
