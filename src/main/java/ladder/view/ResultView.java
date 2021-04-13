package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.Person;

public final class ResultView {


    private static class ResultViewHolder {
        private static final ResultView instance = new ResultView();
    }

    private ResultView() {
    }

    public static final ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public final void printLadder(People people, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        people.stream()
                .map(Person::getName)
                .map(name -> String.format("%-6s", name))
                .forEach(stringBuilder::append);
        stringBuilder.append("\n");

        ladder

    }

}
