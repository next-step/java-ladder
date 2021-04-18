package ladder.domain.ladder;

import ladder.domain.participant.Person;

import java.util.Map;

public final class LadderResultBoard {

    private final Map<Person, String> resultBoard;

    public LadderResultBoard(Map<Person, String> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public static final LadderResultBoard of(Map<Person, String> resultBoard) {
        return new LadderResultBoard(resultBoard);
    }

    public final String findResultByPerson(Person person) {
        return resultBoard.get(person);
    }
}
