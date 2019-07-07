package domain.ladder;

import util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Goals {
    private List<String> goals;

    public Goals(String results) {
        String[] goals = StringUtils.toStringArrays(results);
        this.goals = new ArrayList<>();
        this.goals.addAll(Arrays.asList(goals));
    }

    public String result(int position) {
        return this.goals.get(position);
    }

    public List<String> getGoals() {
        return goals;
    }

    public String findGoal(int position) {
        return goals.get(position);
    }
}
