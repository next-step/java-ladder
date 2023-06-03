package ladder.view;

import ladder.domain.*;

import java.util.Arrays;

public class ResultView {

    public void viewRadderResult(Persons persons, Radder radder, Prize prize) {
        System.out.println("사다리 결과\n");

        viewPersons(persons);
        viewRadder(radder);
        viewPrize(prize);
    }

    private void viewPersons(Persons persons) {
        Arrays.stream(persons.getNames())
                .forEach(s -> System.out.print(String.format("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", s)));
        System.out.println("");
    }

    private void viewRadder(Radder radder) {
        radder.getLines().stream().forEach(this::drawLine);
    }

    private void viewPrize(Prize prize) {
        Arrays.stream(prize.getDescriptions())
                .forEach(s -> System.out.print(String.format("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", s)));
        System.out.println("");
    }

    private void drawLine(Line line) {
        line.getPoints().stream()
                .forEach(x -> System.out.print("|" + drawHorizontal(x.isRight())));
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
