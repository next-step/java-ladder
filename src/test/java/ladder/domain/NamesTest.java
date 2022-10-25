package ladder.domain;

import ladder.domain.Name;
import ladder.domain.Names;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    public void 사람이름_쉼표로_구분(String candidates) {
        Names names = Names.createNames(candidates);
        assertThat(names.getNames().size()).isEqualTo(4);
        assertThat(names.getNames().contains(new Name("pobi"))).isTrue();
        assertThat(names.getNames().contains(new Name("honux"))).isTrue();
        assertThat(names.getNames().contains(new Name("crong"))).isTrue();
        assertThat(names.getNames().contains(new Name("jk"))).isTrue();
    }
}
