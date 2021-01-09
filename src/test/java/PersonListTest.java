import domain.PersonList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PersonListTest {
    @Test
    void split() {
        PersonList personList = new PersonList();
        personList.split("pobi,honux,crong,jk");

        assertThat(personList.size()).isEqualTo(4);
    }
}
