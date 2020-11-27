package step03.domain;
import exception.NotMatchedCountException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Matcher {
    private final Participants participants;
    private final NamesOfResult namesOfResult;
    private final List<Integer> matchedTable;

    private Matcher(Builder builder) {
        this.participants = builder.participants;
        this.namesOfResult = builder.namesOfResult;
        this.matchedTable = builder.matchedTable;
    }


    public static class Builder {
        private final Participants participants;
        private NamesOfResult namesOfResult;
        private List<Integer> matchedTable;

        private Builder(Participants participants) {
            this.participants = participants;
        }

        public static Builder of(Participants participants) {
            return new Builder(participants);
        }

        public Builder namesOfResult(NamesOfResult namesOfResult) {
            this.namesOfResult = namesOfResult;
            validateCount(participants.size(), namesOfResult.size());
            return this;
        }

        public Builder matchedTable(List<Integer> matchedTable) {
            this.matchedTable = matchedTable;
            validateCount(participants.size(), matchedTable.size());
            return this;
        }

        public Matcher build() {
            return new Matcher(this);
        }

        private void validateCount(int count1, int count2) {
            if (count1 != count2) {
                throw new NotMatchedCountException();
            }
        }

    }

    public String getResultByParticipant(String nameOfParticipant) {
        int indexOfName = participants.indexOf(nameOfParticipant);
        int indexOfMatched = matchedTable.indexOf(indexOfName);
        return namesOfResult.getNames().get(indexOfMatched);
    }

    public Map<String, String> getResults() {
        Map<String, String> map = new HashMap<>();

        List<String> namesOfParticipant = participants.getNames();
        List<String> namesOfResult2 = namesOfResult.getNames();

        for(int i = 0; i < participants.size(); i++) {
            int targetIndex = matchedTable.indexOf(i);
            map.put(namesOfParticipant.get(i), namesOfResult2.get(targetIndex));
        }

        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matcher matcher = (Matcher) o;
        return Objects.equals(participants, matcher.participants) &&
                Objects.equals(namesOfResult, matcher.namesOfResult) &&
                Objects.equals(matchedTable, matcher.matchedTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, namesOfResult, matchedTable);
    }
}
