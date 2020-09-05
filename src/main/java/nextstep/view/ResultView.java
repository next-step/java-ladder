package nextstep.view;

import nextstep.entity.Entries;

public class ResultView {

    private final String NAME_FORMAT = "%6s";

    public void printEntries(Entries entries) {
        entries.getNames().stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(System.out::print);
        System.out.println();
    }
}
