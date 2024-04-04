package nextstep.ladder.presentation;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    public void printInputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요.)");
    }

    public void printInputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadderAndUserNames(Ladder ladder, Users users) {
        System.out.printf("실행 결과%n%n");
        users.getUsers().forEach(user -> System.out.printf("%5s ",user.getUserName()));
        System.out.println();
        ladder.getLines().forEach(this::printLine);
        ladder.getLadderResult().forEach(result -> System.out.printf("%-5s ",result));
        System.out.println();
    }

    public void printInputLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    private void printLine(Line line) {
        String bridge = "-----";
        String emptyBridge = "     ";
        String deliminator = "|";

        System.out.print("     ");
        line.getLine().forEach(data -> {
            System.out.printf(deliminator);
            if (data) {
                System.out.printf(bridge);
                return;
            }

            System.out.printf(emptyBridge);
        });

        System.out.println(deliminator);
    }
}
