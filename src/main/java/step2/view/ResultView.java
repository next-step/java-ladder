package step2.view;

import step2.domain.*;

import java.util.List;

public class ResultView {
    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String NEW_LINE = System.lineSeparator();

    public static void print(Persons persons, Ladder ladder) {
        arrangePersons(persons.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladder);
    }

    private static void arrangePersons(List<Person> persons){
       persons.stream()
              .map(person -> formatName(person.getName()))
              .forEach(name -> {
                  System.out.print(name);
              });
    }

    private static String formatName(String name) {
        return String.format(PERSON_NAME_FORMAT, name);
    }

    private static void arrangeLadder(Ladder ladder) {
        ladder.getLayers()
              .stream()
              .forEach(line -> {
                  System.out.println(line.toString());
              });
    }
}
