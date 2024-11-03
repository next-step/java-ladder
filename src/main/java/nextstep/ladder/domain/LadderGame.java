package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static PersonResults result(Persons persons, Ladders ladders, Results results) {
        validate(persons, results);
        List<PersonResult> personResults = new ArrayList<>();

        for (int i = 0; i < persons.personCount(); i++) {
            int resultIndex = searchIndex(i, ladders);
            personResults.add(new PersonResult(persons.searchIndex(i), results.searchIndex(resultIndex)));
        }
        return new PersonResults(personResults);
    }

    private static int searchIndex(int index, Ladders ladders) {
        return ladders.searchIndex(index);
    }

    private static void validate(Persons persons, Results results) {
        if (persons.personCount() != results.resultSize()) {
            throw new IllegalArgumentException("참가자와 결과 사이즈가 같지 않습니다");
        }
    }

}
