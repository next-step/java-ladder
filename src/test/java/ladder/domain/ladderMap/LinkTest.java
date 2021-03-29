package ladder.domain.ladderMap;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkTest {

    @Test
    @DisplayName("연속으로 링크를 생성하지 않는다")
    void doesNotGenerateConsecutiveLinks() {
        List<Link> linkList = initLinkList(10000);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int idx = 1; idx < linkList.size(); idx++) {
            softAssertions.assertThat(linkList.get(idx).from() != linkList.get(idx - 1).from() + 1).isTrue();
        }
        softAssertions.assertAll();
    }

    private List<Link> initLinkList(int upperBound) {
        List<Link> linkList = new ArrayList<>();
        for (int idx = 0; idx < upperBound; idx++) {
            linkList.add(new Link(idx));
        }
        return linkList.stream()
                .filter(link -> !link.empty())
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -99999, 0x80000000})
    @DisplayName("음수를 링크 인덱스로 주면 INVALID_LINK_INDEX을 던진다")
    void negativeInputThrowsException(int inputInteger) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Link(inputInteger));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_LINK_INDEX);
    }

}
