package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomLinkGeneratorTest {

    LinkGenerator linkGenerator = RandomLinkGenerator.getInstance();

    @Test
    @DisplayName("라인 생성 확률이 50프로에 근접해야 한다.")
    void test_isPossibleToLink_probability() {
        // Given
        int testCount = 10_000_000;
        int createLinkCount = 0;

        // When
        for (int count = 0; count < testCount; count++) {
            createLinkCount =
                    linkGenerator.isPossibleToLink() ? createLinkCount + 1 : createLinkCount;
        }

        // Then
        boolean result = createLinkCount - (testCount / 2) < testCount / 1000;
        assertTrue(result);
    }

}