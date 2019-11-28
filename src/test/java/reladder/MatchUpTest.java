package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.MatchUp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchUpTest {

    private MatchUp matchUp;

    @BeforeEach
    void setUp() {
        // give
        matchUp = new MatchUp("a,b,c,d", "1,2,3,4");
    }

    @Test
    @DisplayName("사다리 타기 사람 수")
    void matchUpPeopleCountTest() {
        // when
        int peopleCount = matchUp.getPeopleCount();
        // then
        assertThat(peopleCount).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 타기 경품 수")
    void matchUpResultCountTest() {
        // when
        int resultCount = matchUp.getResultCount();
        // then
        assertThat(resultCount).isEqualTo(4);
    }

    @Test
    @DisplayName("사람 수와 경품 수 같은지 테스트")
    void peopleSizeSameResultSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            MatchUp matchUp = new MatchUp("a,b,c,d", "1,2,3");
        });
    }

    @Test
    @DisplayName("경품 인덱스로 이름 가져오기")
    void getNameWithIndexResultTest() {
        // when
        String name = matchUp.getResultByPosition(1);
        // then
        assertThat(name).isEqualTo("2");
    }

    @Test
    @DisplayName("사람 이름으로 현재 포지션 가져오기")
    void getIndexWithPersonName() {
        // when
        int index = matchUp.getPositionByName("a");
        // then
        assertThat(index).isEqualTo(0);
    }
}
