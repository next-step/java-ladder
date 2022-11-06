package nextstep.ladder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Name> names = InputView.queryNames();
        if (names.size() <= 1) {
            throw new IllegalArgumentException("참여 인원이 너무 적습니다.");
        }
        LadderMaxHeight maxHeight = InputView.queryMaxHeight();
    }
}
