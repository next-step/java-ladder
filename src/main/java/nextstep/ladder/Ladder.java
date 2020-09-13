package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<User> users = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private final int countOfUsers;
    private final int ladderHeight;


    public Ladder(String[] userStrArr, int ladderHeight) {
        this.countOfUsers = userStrArr.length;
        this.ladderHeight = ladderHeight;

        users = Arrays.stream(userStrArr)
                .map(User::new)
                .collect(Collectors.toList());

        for(int i = 0; i < ladderHeight ; i ++){
            lines.add(new Line(countOfUsers));
        }
    }

    public String getLadderStr(){
        StringBuilder str = new StringBuilder();

        String userStr = users.stream()
                                .map(User::toString)
                                .collect(Collectors.joining(" "));

        String ladderStr = lines.stream()
                                    .map(Line::toString)
                                    .collect(Collectors.joining("\n"));

        str.append(userStr).append("\n").append(ladderStr);

        return str.toString();
    }
}
