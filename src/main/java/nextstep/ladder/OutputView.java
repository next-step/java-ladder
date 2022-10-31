package nextstep.ladder;

public class OutputView {

    private static final String BLANK = "     ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String TAB = "\t";

    public static void outputResult(Person people, Ladder ladder) {
        System.out.println("실행결과\n");

        outputPerson(people);
        outputLadder(ladder);
    }

    private static void outputLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            outputLines(line);
        }
    }

    private static void outputLines(Line line) {
        for (boolean bool : line.points) {
            System.out.print(VERTICAL_LINE);
            System.out.print(getLine(bool));
        }
        System.out.println(VERTICAL_LINE);
    }

    private static String getLine(boolean isBoolean) {
        if (isBoolean) {
            return HORIZONTAL_LINE;
        }
        return BLANK;

    }

    private static void outputPerson(Person person) {
        person.getPerson()
                .stream()
                .forEach(p -> System.out.print(p + TAB));

        System.out.println();
    }

}
