package nextstep.ladder;

import nextstep.ladder.model.GamerResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GamerResultTest {

    private GamerResult gamerResult;

    @BeforeEach
    public void setUp() {
        gamerResult = new GamerResult();
    }

    @Test
    void 결과_추가() {
        gamerResult.addResult("홍길동", "100점");

        assertThat(gamerResult.getResultByName("홍길동")).isEqualTo("100점");
    }

    @Test
    void 결과_조회() {
        gamerResult.addResult("이순신", "90점");

        assertThat(gamerResult.getResultByName("이순신")).isEqualTo("90점");
    }

    @Test
    void 잘못된_이름으로_결과_조회() {
        assertThat(gamerResult.getResultByName("잘못된이름")).isNull();
    }

    @Test
    void 여러_결과_추가() {
        gamerResult.addResult("김유신", "80점");
        gamerResult.addResult("강감찬", "70점");

        assertThat(gamerResult.getResultByName("김유신")).isEqualTo("80점");
        assertThat(gamerResult.getResultByName("강감찬")).isEqualTo("70점");
    }

    @Test
    void 모든_결과_조회() {
        gamerResult.addResult("제갈량", "60점");
        gamerResult.addResult("장비", "50점");
        Map<String, String> results = gamerResult.getResults();

        assertThat(results).hasSize(2);
        assertThat(results.get("제갈량")).isEqualTo("60점");
        assertThat(results.get("장비")).isEqualTo("50점");
    }
}
