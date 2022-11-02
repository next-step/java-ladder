package ladder.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ladder.domain.EdgeLine;
import ladder.domain.User;
import ladder.domain.Users;

class DisplayerFactoryTest {
    @Test
    void createInstance() {
        assertThat(DisplayerFactory.createLineDisplayer(List.of(new EdgeLine(5)), 3)).isInstanceOf(LineDisplayer.class);
        assertThat(DisplayerFactory.createUserDisplayer(new Users(List.of(new User("name"))), 3)).isInstanceOf(UserDisplayer.class);
        assertThat(DisplayerFactory.createResultDisplayer(List.of("result"), 3)).isInstanceOf(ResultDisplayer.class);
    }
}
