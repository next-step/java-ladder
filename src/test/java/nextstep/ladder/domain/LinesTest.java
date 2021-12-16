package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class LinesTest {

    @Test
    void create() {
        int height = 5;
        Lines lines = Lines.of(Users.createByString(UsersTest.NAMES), new Height(height));
        assertThat(lines.getLines().size()).isEqualTo(height);
    }
}