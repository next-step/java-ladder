package ladder.domain;

import ladder.dto.LadderWinningDTO;
import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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


    public List<LadderWinningDTO> getOneWinningResult(String name) {
        List<LadderWinningDTO> winningList = new ArrayList<>();

        Optional<Person> paramPerson = persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst();

        winningList.add(mappingWinning(paramPerson.get()));

        return winningList;
    }

    public List<LadderWinningDTO> getAllWinningResult() {
        List<LadderWinningDTO> winningList = new ArrayList<>();

        for (Person person : persons) {
            winningList.add(mappingWinning(person));
        }

        return winningList;
    }

    private LadderWinningDTO mappingWinning(Person person) {
        LadderWinningDTO ladderWinningDTO = new LadderWinningDTO(persons.get(person.getPosition()).getName()
                , winnings.get(person.getPosition()).getWinning());
        return ladderWinningDTO;
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
