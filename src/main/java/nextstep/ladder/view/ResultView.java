package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.ExecuteResults;
import nextstep.ladder.domain.user.Participants;

import java.util.Arrays;

public final class ResultView {

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static void drawInputResult(Participants participants,
                                       ExecuteResults executeResults,
                                       Ladder ladder) {
        System.out.println("\n실행결과\n");
        System.out.println(participants);
        System.out.println(ladder);
        System.out.println(executeResults);
    }

    public static void drawUserResult(String... results) {
        System.out.println("\n실행결과");
        Arrays.stream(results)
                .forEach(System.out::println);
    }

}
