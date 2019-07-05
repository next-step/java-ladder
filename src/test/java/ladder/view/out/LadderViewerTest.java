package ladder.view.out;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderViewerTest {

	@Test
	void renderNames() {
		List<String> messages = new ArrayList<>();
		LadderViewer viewer = new LadderViewer(message -> {
			messages.add(message);
		});

		// Action
		viewer.renderNames(Arrays.asList("test", "user", "longname"));

		// Assertion
		assertThat(messages.size()).isEqualTo(1);
		assertThat(messages.get(0)).isEqualTo("  test  user longn");
	}
}