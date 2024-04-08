package nextstep.ladder.service;

import nextstep.ladder.domain.generator.LineGenerator;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.result.LadderResult;

import java.util.ArrayList;
import java.util.List;

public class LadderService {
    private final LineGenerator lineGenerator;

    public LadderService(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Users makeUsers(String[] userNames) {
        return new Users(userNames);
    }

    public LadderResult generateLadder(Users users, int ladderHeight) {
        int ladderLength = users.getUserCount();

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(lineGenerator.lineGenerate(ladderLength)));
        }

        Ladder ladder = new Ladder(lines);
        //LadderResult

        return new LadderResult(users, ladder);
    }
}
