package nextstep.ladder;

public class OutputView {

    public static void outputResult(Person people, Ladder ladder) {
        outputPerson(people);

        for (Line line : ladder.getLines()) {
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
    }

    private static void outputPerson(Person person) {
            person.getPerson()
                .stream()
                .forEach(p -> System.out.print(p + "\t"));

        System.out.println();
    }

}
