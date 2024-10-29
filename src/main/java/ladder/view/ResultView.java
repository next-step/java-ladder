package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String ALL = "all";
    private static final String DELIMITER = " : ";
    private static final String NOT_EXIST_ERROR_MESSAGE = "존재하지 않는 사람입니다.";
    private static final String NO_LADDER = "     |";
    private static final String EXIST_LADDER = "-----|";
    private static final String LADDER_RESULT_SENTENCE = "사다리 결과";
    private static final String RESULT_SENTENCE = "  실행 결과  ";

    private final LadderResult ladderResult;
    private final Persons persons;

    public ResultView(LadderResult ladderResult, Persons persons) {
        this.ladderResult = ladderResult;
        this.persons = persons;
    }

    public void getResultView(Ladder ladder) {
        System.out.println();
        System.out.println(LADDER_RESULT_SENTENCE);
        System.out.println();
        getPersonsResultView();

        getLadderResultView(ladder);

        getLadderPrizeResultView();

        getLadderGameResultView();
    }

    private void getPersonsResultView() {
        String names = persons.getPersons().stream()
                .map(Person::getName)
                .map(name -> String.format("%7s", name))
                .collect(Collectors.joining(""));

        System.out.println(names);
    }

    private void getLadderResultView(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getPoints)
                .forEach(ResultView::makeLadder);


    }

    private void getLadderPrizeResultView() {
        String prizeResults = IntStream.range(0, persons.getSize())
                .mapToObj(index -> String.format("%6s", ladderResult.getResult(index)))
                .collect(Collectors.joining(""));

        System.out.println(prizeResults);
    }

    private static void makeLadder(List<Boolean> line) {
        line.forEach(value -> {
            System.out.print(makeLadder(value));
        });
        System.out.println();
    }

    private static String makeLadder(boolean hasLine) {
        if (hasLine) {
            return EXIST_LADDER;
        }
        return NO_LADDER;
    }

    public void getLadderGameResultView() {
        boolean flag = false;

        while (!flag) {
            String name = InputView.getLadderPlayResult();
            System.out.println(RESULT_SENTENCE);
            flag = makeLadderGameResultView(name);
        }

    }

    private boolean makeLadderGameResultView(String name) {
        if(name.equals(ALL)) {
            persons.getPersons().forEach(person -> {
                System.out.print(person.getName()+DELIMITER);
                System.out.println(ladderResult.getResult(person.getPoint()));
            });
            return true;
        }

        Person person = persons.isSamePerson(name).orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_ERROR_MESSAGE));
        System.out.println(ladderResult.getResult(person.getPoint()));
        return false;
    }

}
