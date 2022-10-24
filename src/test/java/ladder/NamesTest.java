package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    public void 사람이름_쉼표로_구분() {
        Names names = new Names("pobi,honux,crong,jk");
        assertThat(names.getNames().size()).isEqualTo(4);
        assertThat(names.getNames().contains(new Name("pobi"))).isTrue();
        assertThat(names.getNames().contains(new Name("honux"))).isTrue();
        assertThat(names.getNames().contains(new Name("crong"))).isTrue();
        assertThat(names.getNames().contains(new Name("jk"))).isTrue();
    }
}
