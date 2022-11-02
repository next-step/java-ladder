package ladder.domain.person;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SearchPeopleNamesTest {

    @Test
    void create() {
        SearchPeopleNames actual = new SearchPeopleNames("pobi", "crong");

        assertThat(actual).isEqualTo(new SearchPeopleNames(List.of(new PersonName("pobi"), new PersonName("crong"))));
    }
}
