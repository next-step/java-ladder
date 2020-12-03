package ladder.domain.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-03.
 */
public class NamesTest {

    @Test
    void 여러_이름을_한번에_받는다() {
        String inputNames = "가,포비,twice";

        Names names = Names.from(inputNames);

        assertThat(names).isEqualTo(Names.from(inputNames));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 참가자_명단은_비어있으면_안된다(String inputNames) {
        assertThatThrownBy(() -> Names.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Names.MESSAGE_PARTICIPANTS_LIST_NON_NULL);
    }

}
