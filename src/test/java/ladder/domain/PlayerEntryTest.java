package ladder.domain;

import ladder.model.PlayerRailPair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayerEntryTest {

	@DisplayName("허용길이보다 긴 이름추가 시도")
	@Test
	void appendLongName() {
		String nameOfSix = "abcdef";

		PlayerEntry entry = new PlayerEntry();
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					entry.append(nameOfSix);
				});
	}

	@ParameterizedTest
	@NullAndEmptySource
	void appendNullOrEmpty(String playerName){
		PlayerEntry entry = new PlayerEntry();
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					entry.append(playerName);
				});
	}

	@Test
	void getRailNumber() {
		PlayerEntry playerEntry = new PlayerEntry();
		playerEntry.append("first");
		playerEntry.append("2nd");

		assertThat(playerEntry.getEntry("first").getRailNumber()).isEqualTo(0);
		assertThat(playerEntry.getEntry("2nd").getRailNumber()).isEqualTo(1);
	}

	@Test
	void entrySet() {
		PlayerEntry playerEntry = new PlayerEntry();
		playerEntry.append("first");
		playerEntry.append("2nd");

		List<PlayerRailPair> entries = playerEntry.entries();
		assertThat(entries).containsExactly(
				new PlayerRailPair("first", 0),
				new PlayerRailPair("2nd", 1)
		);

	}
}