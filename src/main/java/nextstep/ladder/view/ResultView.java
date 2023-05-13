package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

public class ResultView {

    static void printPeopleInputCommand() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    static void printHeightInputCommand() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(Ladder ladder) {
        System.out.println("실행결과");
        printNewLine();

        System.out.println("ladder.people() = " + ladder.people());
        System.out.println("ladder.lines() = " + ladder.lines());
    }

    private static void printNewLine() {
        System.out.println();
    }


}
