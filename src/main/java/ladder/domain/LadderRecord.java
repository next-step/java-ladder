package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRecord {
    private List<String> users;
    private List<String> outcomes;

    public LadderRecord(List<String> users, List<String> outcomes) {
        checkSize(users.size(), outcomes.size());
        this.users = users;
        this.outcomes = outcomes;
    }

    private void checkSize(int userSize, int outcomeSize) {
        if (userSize != outcomeSize) {
            throw new IllegalArgumentException("유저수와 결과수를 같게 입력해주세요");
        }
    }

    public int getWidth() {
        return users.size() - 1;
    }

    public String getUserFormat() {
        return users.stream()
                .map(this::fillCharacter)
                .collect(Collectors.joining());
    }

    public String getOutcomeFormat() {
        return outcomes.stream()
                .map(this::fillCharacter)
                .collect(Collectors.joining());
    }

    private String fillCharacter(String value) {
        return String.format("%-6s", value);
    }

    public List<UserRecord> run(List<Line> lines) {
        List<UserRecord> userRecords = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            userRecords.add(goLine(i, lines));
        }

        return userRecords;
    }

    private UserRecord goLine(int index, List<Line> lines) {
        UserRecord userRecord = new UserRecord(users.get(index), index);
        userRecord.recordPoints(lines);
        userRecord.addOutcome(outcomes);
        return userRecord;
    }

}
