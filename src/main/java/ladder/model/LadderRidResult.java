package ladder.model;

import java.util.List;

public class LadderRidResult {

    private List<String> allUserResults;
    private StringBuilder userMatchResult;

    public LadderRidResult(Users users, List<String> allUserResults) {
        this.userMatchResult = ladderResultMatchUsers(users, allUserResults);
        this.allUserResults = allUserResults;
    }

    public LadderRidResult(String userResult) {
        this.userMatchResult = new StringBuilder().append(userResult);
    }

    public static LadderRidResult of(Users users, List<String> allUserResults) {
        return new LadderRidResult(users, allUserResults);
    }

    public static LadderRidResult of(String userResult) {
        return new LadderRidResult(userResult);
    }

    private StringBuilder ladderResultMatchUsers(Users users, List<String> allUserResults) {
        StringBuilder userMatchResult = new StringBuilder();
        for (int i = 0; i < allUserResults.size(); i++) {
            userMatchResult.append(
                    users.getUsers().get(i).getName()
                         .concat(" : ")
                         .concat(allUserResults.get(i)
                         .concat("\n"))
            );
        }
        return userMatchResult;
    }

    public String getMatchResult() {
        return this.userMatchResult.toString();
    }

    public List<String> getAllUserMatchResult() {
        return allUserResults;
    }

}
