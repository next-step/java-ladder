package nextstep.ladder;

public class OutputView {

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
            System.out.print("|");
            if (bool) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }
        }
        System.out.println("|");
    }

    private static void outputPerson(Person person) {
            person.getPerson()
                .stream()
                .forEach(p -> System.out.print(p + "\t"));

        System.out.println();
    }

}
