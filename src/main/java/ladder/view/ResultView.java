package ladder.view;

import ladder.domain.Names;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_INTERVAL = "  ";

    public void printResult() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printNames(Names names) {
        System.out.println();
        names.names().stream()
            .forEach(name -> {
                System.out.print(name.name());
                System.out.print(NAME_INTERVAL);
            });
    }

}
