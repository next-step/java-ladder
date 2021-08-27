package laddergameplay.view;

import laddergameplay.domain.*;

import java.util.Map;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";
    private static final int PERSON_DISPLAY_SPACE = Person.MAX_LENGTH_OF_NAME + 1;
    private static final int RESULT_DISPLAY_SPACE = Result.MAX_LENGTH_OF_NAME + 1;

    public static void showResult(People people, Ladder ladder, Results results) {
        String result = makeResult(people, ladder, results);

        System.out.println(result);
    }

    private static String makeResult(People people, Ladder ladder, Results results) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("사다리 결과")
                .append(System.lineSeparator());

        writePeople(people, stringBuilder);
        writeLadder(ladder, stringBuilder);
        writeResults(results, stringBuilder);

        return stringBuilder.toString();
    }

    private static void writePeople(People people, StringBuilder stringBuilder) {
        people.getPeople()
                .stream()
                .map(Person::toString)
                .map(name -> String.format("%"+ RESULT_DISPLAY_SPACE +"s", name))
                .forEach(stringBuilder::append);
        stringBuilder.append(System.lineSeparator());
    }

    private static void writeLadder(Ladder ladder, StringBuilder stringBuilder) {
        ladder.getLadder()
                .forEach(line -> { stringBuilder.append(LINE_EMPTY)
                        .append(makeLineResult(line))
                        .append(System.lineSeparator());
                });
    }

    private static String makeLineResult(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.getPoints()
                .stream()
                .map(ResultView::ladderString)
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private static String ladderString(Boolean bool) {
        if (bool) {
            return LINE_EXIST;
        }
        return LINE_EMPTY;
    }

    private static void writeResults(Results results, StringBuilder stringBuilder) {
        results.getResults()
                .stream()
                .map(Result::toString)
                .map(name -> String.format("%"+ PERSON_DISPLAY_SPACE +"s", name))
                .forEach(stringBuilder::append);
        stringBuilder.append(System.lineSeparator());
    }


    public static void showWinningResult(WinningResult winningResult) {
        while(true) {
            String personName = InputView.inputPerson();
            showResult(winningResult, personName);
        }
    }

    private static void showResult(WinningResult winningResult, String personName) {
        showAllOrElse(winningResult, personName);
    }

    private static void showAllOrElse(WinningResult winningResult, String personName) {
        if (personName.equals("all")) {
            showAllWinningResult(winningResult.findAll());
            return;
        }
        showExitOrElse(winningResult, personName);
    }

    private static void showAllWinningResult(Map<Person, Result> winningResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("실행 결과")
                .append(System.lineSeparator());

        winningResult.forEach((person, result) -> {
            stringBuilder.append(person)
                    .append(" : ")
                    .append(result)
                    .append(System.lineSeparator());
        });
        String result = stringBuilder.toString();
        System.out.println(result);
    }

    private static void showExitOrElse(WinningResult winningResult, String personName) {
        if(personName.equals("exit")){
            System.exit(0);
            return;
        }
        showOneResult(winningResult, personName);
    }

    private static void showOneResult(WinningResult winningResult, String personName) {
        Person personToFind = new Person(personName);
        showOneWinningResult(winningResult.findBy(personToFind));
    }

    private static void showOneWinningResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}


