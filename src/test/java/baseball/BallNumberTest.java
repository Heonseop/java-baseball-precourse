package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.model.BallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallNumberTest {
    @DisplayName("야구_숫자_1_9_검증")
    @Test
    void 야구_숫자_1_9_검증() {
        assertThat(new BallNumber(9).getNum()).isEqualTo(9);
        assertThat(new BallNumber(1).getNum()).isEqualTo(1);
    }

    @DisplayName("야구_숫자_1_9_범위_넘으면_예외_처리")
    @ParameterizedTest
    @CsvSource(value = {"0", "10"}, delimiter = ':')
    void 야구_숫자_0_10_예외_처리(int num) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallNumber(num));
    }
}
