package ladder.view;

import ladder.domain.*;

import java.util.Arrays;

public class ResultView {

    public void viewLadderResult(Persons persons, Ladder ladder, Prize prize) {
        System.out.println("사다리 결과\n");

        viewPersons(persons);
        viewLadder(ladder);
        viewPrize(prize);
    }

    private void viewPersons(Persons persons) {
        Arrays.stream(persons.getNames())
                .forEach(s -> System.out.print(String.format("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", s)));
        System.out.println("");
    }

    private void viewLadder(Ladder ladder) {
        ladder.getLines().stream().forEach(this::drawLine);
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

    public void viewResultTitle() {
        System.out.println("\n실행 결과");

    }

    public void viewPersonResult(Person person, String prize) {
        System.out.println(person + " : " + prize);
    }
}
