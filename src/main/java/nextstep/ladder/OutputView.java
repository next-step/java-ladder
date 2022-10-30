package nextstep.ladder;

public class OutputView {

    public static void outputLadder(Person person, Line line) {
        System.out.println("실행결과\n");

        person.getPerson()
                .stream()
                .forEach(p -> System.out.print(p + "\t"));

        System.out.println();

        for (int i = 0; i < line.getHeight(); i++) {
            person.getPerson()
                    .stream()
                    .forEach(p -> System.out.print("\t|\t"));
            System.out.println();
        }

    }
}
