package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class GameCriteriaTest {

    @Test
    @DisplayName("User와 Result 매핑")
    void mapUsernameResult() {
        User user1 = User.of(0, "java");
        User user2 = User.of(1, "study");
        User user3 = User.of(2, "game");
        Users users = Users.from(Arrays.asList(user1, user2, user3));

        Result result1 = Result.of(0, "1000");
        Result result2 = Result.of(1, "2000");
        Result result3 = Result.of(2, "3000");
        Results results = Results.from(Arrays.asList(result1, result2, result3));

        GameCriteria gameCriteria = GameCriteria.of(users, results);

        // |-| |
        // | |-|
        Point point1 = Point.setFirst(previous -> true);
        Index index1 = Index.of(0, point1);
        Point point2 = point1.setNext(previous -> false);
        Index index2 = Index.of(1, point2);
        Point point3 = point2.setLast();
        Index index3 = Index.of(2, point3);
        Line line1 = Line.from(Arrays.asList(index1, index2, index3));

        Point point4 = Point.setFirst(previous -> false);
        Index index4 = Index.of(0, point4);
        Point point5 = point4.setNext(previous -> true);
        Index index5 = Index.of(1, point5);
        Point point6 = point5.setLast();
        Index index6 = Index.of(2, point6);
        Line line2 = Line.from(Arrays.asList(index4, index5, index6));

        Ladder ladder = Ladder.from(Arrays.asList(line1, line2));

        Map<String, Result> stringResultMap = gameCriteria.mapUsernameResult(ladder);

        Map<String, Result> newResultMap = new LinkedHashMap<>();
        newResultMap.put("java", result3);
        newResultMap.put("study", result1);
        newResultMap.put("game", result2);

        Assertions.assertThat(stringResultMap).isEqualTo(newResultMap);
    }

}
