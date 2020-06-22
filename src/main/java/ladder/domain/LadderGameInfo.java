package ladder.domain;

import java.util.List;

public class LadderGameInfo {

    public static final String LADDER_RESULTS_INVALID_EXCEPTION = "결과값은 참여자 숫자와 다를 수 없습니다.";

    private final Persons persons;
    private final Prizes prizes;

    private LadderGameInfo(Persons persons, Prizes prizes) {
        validateGameInfo(persons,prizes);
        this.persons = persons;
        this.prizes = prizes;
    }

    private void validateGameInfo(Persons persons, Prizes prizes) {
        if (persons.count() != prizes.count()){
            throw new IllegalArgumentException(LADDER_RESULTS_INVALID_EXCEPTION);
        }
    }

    public static LadderGameInfo of(Persons persons, Prizes prizes){
        return new LadderGameInfo(persons, prizes);
    }

    public List<Person> getPersons() {
        return persons.getPersons();
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
