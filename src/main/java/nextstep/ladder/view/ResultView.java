package nextstep.ladder.view;

import nextstep.ladder.model.People;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String NAME_FORMAT = "%6s";

    public void printResult(People people) {
        printTitle();
        printPeopleNames(people);
        // System.out.println("     |-----|-----|-----|");
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    private void printPeopleNames(People people) {
        people.getPeopleNames()
            .forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }
}
