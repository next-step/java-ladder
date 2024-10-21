package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.dto.ViewDto;

public class OpeningView implements Visible {

    @Override
    public void view(ViewDto viewDto) {
        System.out.println();
        System.out.println("실행결과물");
        System.out.println();
    }
}
