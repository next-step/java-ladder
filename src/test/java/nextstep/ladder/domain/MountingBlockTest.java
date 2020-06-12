package nextstep.ladder.domain;

import nextstep.ladder.dummy.TestRandomMountingBlockGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MountingBlockTest {

    @DisplayName("사다리 발판 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideMountingBlocks")
    void lineConstructorTest(final Boolean beforeMountingBlock, final Boolean currentMountingBlock, final Boolean expected) {
        MountingBlockGenerator mountingBlockGenerator = new TestRandomMountingBlockGenerator(currentMountingBlock);
        MountingBlock mountingBlock = MountingBlock.of(beforeMountingBlock, mountingBlockGenerator);

        assertThat(mountingBlock.getMountingBlock()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMountingBlocks() {
        return Stream.of(
                Arguments.of(Boolean.FALSE, Boolean.TRUE, Boolean.TRUE),
                Arguments.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE)
        );
    }
}
