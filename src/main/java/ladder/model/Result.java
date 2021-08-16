package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ladder.message.ErrorMessage;

public class Result {

	private static final String REGEX = ",";
	private final List<String> results;

	public Result(String results, Players players) {
		checkEmptyResult(results);
		this.results = Collections.unmodifiableList(toList(results, players.findPlayerCount()));
	}

	public List<String> getResults() {
		return results;
	}

	public String findResult(int resultPosition) {
		return results.get(resultPosition);
	}

	private List<String> toList(String results, int playerCount) {
		String[] resultsArray = results.split(REGEX);
		checkResultsLength(resultsArray.length, playerCount);
		return Arrays.stream(resultsArray)
			.collect(Collectors.toCollection(LinkedList::new));
	}

	private void checkResultsLength(int resultCount, int playerCount) {
		if (resultCount != playerCount) {
			throw new IllegalArgumentException(ErrorMessage.NOT_EQUALS_LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkEmptyResult(String results) {
		if (results.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Result result = (Result)o;
		return Objects.equals(getResults(), result.getResults());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getResults());
	}


}
