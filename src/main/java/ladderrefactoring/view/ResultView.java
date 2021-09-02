package ladderrefactoring.view;

import ladderrefactoring.domain.WinningResult;
import ladderrefactoring.domain.data.Person;
import ladderrefactoring.domain.data.Result;
import ladderrefactoring.domain.datas.People;
import ladderrefactoring.domain.datas.Results;
import ladderrefactoring.domain.ladder.Ladder;
import ladderrefactoring.domain.ladder.Line;
import ladderrefactoring.domain.ladder.Point;

import java.util.Map;

public class ResultView {

    public static final int SPACE_OF_PERSON = Person.MAX_LENGTH_OF_NAME+1;
    public static final int SPACE_OF_RESULT = Result.MAX_LENGTH_OF_NAME+1;
    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";

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

        people.people()
                .stream()
                .map(Person::toString)
                .map(name -> String.format("%"+ SPACE_OF_PERSON +"s", name))
                .forEach(stringBuilder::append);

        stringBuilder.append(System.lineSeparator());
    }

    private static void writeLadder(Ladder ladder, StringBuilder stringBuilder) {
        for (Line line : ladder.ladder()) {
            addResultTo(line, stringBuilder);
        }
    }

    private static void addResultTo(Line line, StringBuilder stringBuilder) {
        line.points()
                .stream()
                .map(ResultView::ladderString)
                .forEach(stringBuilder::append);

        stringBuilder.append(System.lineSeparator());
    }

    private static String ladderString(Point point) {
        if (point.direction().left()) {
            return LINE_EXIST;
        }
        return LINE_EMPTY;
    }

    private static void writeResults(Results results, StringBuilder stringBuilder) {
        results.results()
                .stream()
                .map(Result::toString)
                .map(name -> String.format("%"+ SPACE_OF_RESULT +"s", name))
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
        }
        showOneResult(winningResult, personName);
    }

    private static void showOneResult(WinningResult winningResult, String personName) {
        Person personToFind = new Person(personName);
        showOneWinningResult(winningResult.findBy(personToFind));
    }

    private static void showOneWinningResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result + System.lineSeparator());
    }
}


