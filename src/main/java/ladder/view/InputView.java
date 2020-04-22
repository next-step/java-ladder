package ladder.view;

import ladder.domain.Persons;
import ladder.domain.exception.InvalidNamesInputException;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String PERSON_NAMES_DELIMITER = ",";
    private static final String GET_PERSON_NAMES_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static Persons getPersons() {
        System.out.println(GET_PERSON_NAMES_NOTICE);

        String personNames = scanner.nextLine();
        if (!isValidNamesInput(personNames)) {
            throw new InvalidNamesInputException();
        }

        return Persons.getInstanceByPersonNames(personNames.split(PERSON_NAMES_DELIMITER));
    }

    private static boolean isValidNamesInput(String personNames) {
        return !Objects.isNull(personNames) && !personNames.isEmpty();
    }
}
