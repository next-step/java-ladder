package nextstep.ladder.domain;

import java.util.List;

public class PersonResults {
    private static final String SEARCH_ALL = "all";

    private final List<PersonResult> personResults;

    public PersonResults(List<PersonResult> personResults) {
        this.personResults = personResults;
    }

    public List<PersonResult> searchName(String personName) {
        if (personName.equals(SEARCH_ALL)) {
            return personResults;
        }

        return List.of(
                personResults.stream()
                        .filter(personResult -> personResult.isExist(personName))
                        .findFirst()
                        .orElseThrow(
                                () -> new IllegalArgumentException("")
                        )
        );
    }
}
