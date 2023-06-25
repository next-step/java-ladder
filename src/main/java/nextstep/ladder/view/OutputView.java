package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.handler.LadderHandler;

public class OutputView {

    private static final String RESPONSE_RESULT = "실행결과";

    public void responseResult(Peoples peoples) {
        System.out.println(RESPONSE_RESULT);
        printEnter();
        printPeoples(peoples);
        printEnter();
    }

    private void printPeoples(Peoples peoples) {
        peoples.getPeoples().forEach(people -> System.out.printf("%6s", people.getName()));
    }

    public void responseLadder(Ladder ladder) {
        LadderHandler ladderHandler = new LadderHandler();
        ladderHandler.printLadder(ladder);
    }

    private void printEnter() {
        System.out.println();
    }
}
