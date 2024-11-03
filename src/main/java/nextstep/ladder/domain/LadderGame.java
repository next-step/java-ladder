package nextstep.ladder.domain;

public class LadderGame {

    public static void start(Persons persons, Results results, int heightCount) {
        validate(persons, results);

        Ladders ladders = new Ladders(persons.personCount(), heightCount);

    }

    private static void validate(Persons persons, Results results) {
        if (persons.personCount() != results.resultSize()) {
            throw new IllegalArgumentException("참가자와 결과 사이즈가 같지 않습니다");
        }
    }
}
