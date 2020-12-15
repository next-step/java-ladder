package ladder.domain;

import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderWinnings {

    private List<LadderWinning> winnings = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    public LadderWinnings(final String winnings, final Persons persons) {
        checkInputWinning(winnings);

        initLadderWinnings(winnings, persons);
    }

    public void initLadderWinnings(final String winnings, final Persons persons) {
        List<String> winningList = Arrays.asList(winnings.replaceAll(" ", "").split(","));
        checkMakeList(winningList);
        checkListSize(winningList, persons.getPersons());

        LadderWinning ladderWinning;
        for (String winning : winningList) {
            ladderWinning = new LadderWinning(winning);
            this.winnings.add(ladderWinning);
        }
        this.persons = persons.getPersons();
    }

    private void checkListSize(final List<String> winningList, final List<Person> personList) {
        if (winningList.size() != personList.size()) {
            throw new RuntimeException(ErrorMessage.getCheckWinnngSize());
        }
    }

    private void checkMakeList(List<String> winningList) {
        if (winningList.isEmpty()) {
            throw new RuntimeException(ErrorMessage.getCheckInputWinning());
        }
    }

    private void checkInputWinning(final String winnings) {
        checkNull(winnings);
        checkEmpty(winnings);
    }

    private void checkEmpty(final String winnings) {
        if (winnings == null) {
            throw new RuntimeException(ErrorMessage.getCheckInputWinning());
        }
    }

    private void checkNull(final String winnings) {
        if (winnings.isEmpty()) {
            throw new RuntimeException(ErrorMessage.getCheckInputWinning());
        }
    }


    public List<LadderWinning> getWinnings() {
        return winnings;
    }
}
