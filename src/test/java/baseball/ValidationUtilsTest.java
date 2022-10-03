package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    @DisplayName("야구_숫자_1_9_검증")
    void 야구_숫자_1_9_검증() {
        assertThat(ValidationUtils.validNum(9)).isTrue();
        assertThat(ValidationUtils.validNum(1)).isTrue();
        assertThat(ValidationUtils.validNum(0)).isFalse();
        assertThat(ValidationUtils.validNum(10)).isFalse();
    }
}
