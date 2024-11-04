package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    public static PersonResults result(Persons persons, Ladders ladders, Results results) {
        validate(persons, results);
        Map<Person, Result> personResultMap = new LinkedHashMap<>();

        for (int i = 0; i < persons.personCount(); i++) {
            int resultIndex = searchIndex(i, ladders);
            personResultMap.put(persons.searchIndex(i), results.searchIndex(resultIndex));
        }
        return new PersonResults(personResultMap);
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
