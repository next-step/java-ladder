package nextstep.ladder.domain;

import nextstep.ladder.dummy.TestQueueMountingBlockGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineGeneratorTest {

    @DisplayName("사다리 발판 생성 테스트 :: 참여자 수를 입력하면 List<MountingBlock>이 원하는 대로 생성이 되는지?")
    @ParameterizedTest
    @MethodSource("provideLines")
    void lineConstructorTest(final Integer countOfPerson, final Queue<Boolean> wanted, final List<Boolean> expected) {
        LineGenerator lineGenerator = new LineGenerator(new TestQueueMountingBlockGenerator(wanted));
        Line line = lineGenerator.generateLine(countOfPerson);

        List<MountingBlock> mountingBlocks = line.getMountingBlocks();
        List<Boolean> result = mountingBlocks.stream()
                .map(MountingBlock::getMountingBlock)
                .collect(Collectors.toList());

        checkMountingBlocks(result, expected);
    }

    private void checkMountingBlocks(List<Boolean> result, List<Boolean> expected) {
        assertThat(result.size()).isEqualTo(expected.size());
        IntStream.range(0, result.size())
                .forEach(i -> assertThat(result.get(i)).isEqualTo(expected.get(i)));
    }

    private static Stream<Arguments> provideLines() {

        return Stream.of(
                Arguments.of(4, new LinkedList<>(Arrays.asList(Boolean.TRUE, Boolean.FALSE)), Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE)),
                Arguments.of(3, new LinkedList<>(Arrays.asList(Boolean.FALSE, Boolean.TRUE)), Arrays.asList(Boolean.FALSE, Boolean.TRUE))
        );
    }
}
