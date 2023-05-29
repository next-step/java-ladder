package ladder.view;

import ladder.domain.*;
import ladder.domain.enums.Direction;

import java.util.Arrays;

public class ResultView {

    public void viewResult(Persons persons, Radder radder) {
        System.out.println("실행결과\n");

        viewPersons(persons);
        viewRadder(radder);
    }


    private void viewPersons(Persons persons) {
        Arrays.stream(persons.getNames())
                .forEach(s -> System.out.print(String.format("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", s)));
        System.out.println("");
    }

    private void viewRadder(Radder radder) {
        radder.getLines().stream().forEach(this::drawLine);
    }

    private void drawLine(Line line) {
        line.getPoints().stream()
                .forEach(x -> System.out.print("|" + drawHorizontal(x.equals(Direction.RIGHT))));
        System.out.println("");
    }

    private String drawHorizontal(boolean needDrawLine) {
        String result = String.format("%" + Person.MAX_NAME_LENGTH + "s", "");

        if (needDrawLine) {
            result = result.replace(' ', '-');
        }

        return result;
    }
}
