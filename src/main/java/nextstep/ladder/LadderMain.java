package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PersonNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ReviewView;

import java.util.Set;

public class LadderMain {
    public static void main(String[] args) {
        Set<String> personNameInput = InputView.getPersonNameInput("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");
        int height = InputView.getPositiveNumberInput("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(new PersonNames(personNameInput), height);
        ReviewView.printLadder(ladder);
    }
}
