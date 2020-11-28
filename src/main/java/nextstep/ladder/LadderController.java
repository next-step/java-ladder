package nextstep.ladder;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderConfiguration;
import nextstep.ladder.entity.ladder.RandomLinkGenerator;
import nextstep.ladder.entity.ladder.Users;
import nextstep.ladder.view.LadderHeightInputView;
import nextstep.ladder.view.LadderResultView;
import nextstep.ladder.view.UsersInputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    public void ladderGame() {
        // 사용자 입력 받기
        Users users = getUsers();
        // 사다리 높이 입력 받기
        int ladderHeight = getLadderHeight();

        // 사다리 생성
        LadderConfiguration ladderConfiguration = new LadderConfiguration(ladderHeight, users.getUserCount());
        Ladder ladder = Ladder.create(ladderConfiguration, RandomLinkGenerator.getInstance());

        // 출력
        LadderResultView.display(ladder, users);
    }

    private Users getUsers() {
        List<User> users = UsersInputView.getUserInput()
                .stream()
                .map(User::new)
                .collect(Collectors.toList());
        return new Users(users);
    }

    private int getLadderHeight() {
        return LadderHeightInputView.getLadderHeight();
    }

}
