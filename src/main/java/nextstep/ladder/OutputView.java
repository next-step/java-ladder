package nextstep.ladder;

public class OutputView {

    private static void outputPerson(Person person) {
        person.getPerson()
                .stream()
                .forEach(p -> System.out.print(p + "\t"));

        System.out.println();
    }
}
