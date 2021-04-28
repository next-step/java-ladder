package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    private Members members;
    private Results results;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        members = Members.of("a,b,c");
        results = Results.of("1,2,3");
        ladder = Ladder.create(3, 2, new FixedGenerator(true));
    }

    @ParameterizedTest
    @CsvSource(value = {"a,1", "b,2", "c,3"}, delimiter = ',')
    void findOfResults(String findMemberName, String result) {
        Member findMember = new Member(findMemberName);
        Match match = Match.findOfResults(members, ladder, results, findMember);

        assertThat(match.getResultByMember(findMemberName)).isEqualTo(result);
    }
}
