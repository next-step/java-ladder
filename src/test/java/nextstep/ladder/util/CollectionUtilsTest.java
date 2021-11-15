package nextstep.ladder.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CollectionUtilsTest {
	@DisplayName("컬렉션이 비어있는지 검증한다.")
	@ParameterizedTest(name = "{index}. collection : {0}, expected : {1}")
	@MethodSource("provideCollections")
	void isEmpty(Collection<?> collection, boolean expected) {
		// when
		boolean result = CollectionUtils.isEmpty(collection);

		// then
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> provideCollections() {
		return Stream.of(
			Arguments.arguments(Collections.emptyList(), true),
			Arguments.arguments(Arrays.asList("1", "2"), false)
		);
	}
}
