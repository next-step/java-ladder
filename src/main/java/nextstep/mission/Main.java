package nextstep.mission;

import nextstep.mission.domain.Ladder;
import nextstep.mission.domain.Participants;
import nextstep.mission.view.InputScanner;
import nextstep.mission.view.ResultViewer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Participants participants = InputScanner.printMessageAndGetUsers("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println();

        List<String> results = InputScanner.printMessageAndGetResults("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        System.out.println();

        int height = InputScanner.printMessageAndGetHeight("최대 사다리 높이는 몇 개인가요?");
        System.out.println();

        Ladder ladder = Ladder.make(participants, height);
        System.out.println("사다리 결과");
        System.out.println();

        ResultViewer.showLadder(participants, ladder, results);

        String selectCondition = "";

        while (!selectCondition.equals("all")) {
            System.out.println();
            selectCondition = InputScanner.printMessageAndSelectResult("결과를 보고 싶은 사람은?");

            System.out.println();
            System.out.println("실행 결과");

            ResultViewer.showSelectResult(participants, ladder, results, selectCondition);
        }
    }
}
