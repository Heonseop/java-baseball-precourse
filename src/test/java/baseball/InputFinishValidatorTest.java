package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.validator.InputFinishValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputFinishValidatorTest {
    InputFinishValidator inputFinishValidator;

    @BeforeEach
    void before() {
        inputFinishValidator = new InputFinishValidator(1, 2, 1);
    }

    @DisplayName("숫자로된 문자열이 정상적일 경우 True를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "2"})
    void isNumbersValidate_P01(String input) {
        assertThat(inputFinishValidator.isInputValidate(input)).isTrue();
    }

    @DisplayName("문자열의 길이가 정한 크기로 안 들어올 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1124"})
    void isNumbersValidate_N01(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputFinishValidator.isInputValidate(input));
    }

    @DisplayName("문자열이 빈값일 경우 에러를 반환한다.")
    @Test
    void isNumbersValidate_N02() {
        String input = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputFinishValidator.isInputValidate(input));
    }

    @DisplayName("문자열에 숫자가 아닌 값이 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a", "b", "?"})
    void isNumbersValidate_N03(String input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputFinishValidator.isInputValidate(input));
    }

    @DisplayName("문자열에 1-2가아닌 숫자가 있을 경우 에러를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3", "4", "5"})
    void isNumbersValidate_N04(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputFinishValidator.isInputValidate(input));
    }
}
