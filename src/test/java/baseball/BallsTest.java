package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.model.Ball;
import baseball.model.BallStatus;
import baseball.model.Balls;
import baseball.model.PlayResult;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsTest {
    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(4, 7, 6));
    }

    @DisplayName("중복되는_숫자가_있으면_에러_반환")
    @Test
    void 중복되는_숫자가_있으면_에러_반환() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(Arrays.asList(4, 7, 4)));
    }

    @DisplayName("입력값이_3자리가_넘으면_에러_반환")
    @Test
    void 입력값이_3자리가_넘으면_에러_반환() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(Arrays.asList(4, 7, 3, 5)));
    }

    @DisplayName("입력된_문자열이_중복되는_값이_있으면_에러_반환")
    @ParameterizedTest
    @CsvSource(value = {"111", "131", "112"}, delimiter = ':')
    void 입력된_문자열이_중복되는_값이_있으면_에러_반환(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(input));
    }

    @DisplayName("입력된_문자열이_3자리가_넘으면_에러_반환")
    @ParameterizedTest
    @CsvSource(value = {"000000", "1000000"}, delimiter = ':')
    void 입력된_문자열이_3자리가_넘으면_에러_반환(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(input));
    }

    @DisplayName("입력된_문자열이_숫자변환이_안되면_에러_반환")
    @ParameterizedTest
    @CsvSource(value = {"abc", "1aa", "12A", "1a1"}, delimiter = ':')
    void 입력된_문자열이_숫자변환이_안되면_에러_반환(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(input));
    }

    @Test
    void play_nothing() {
        Balls testBalls = new Balls(Arrays.asList(9, 1, 2));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_one_strike() {
        Balls testBalls = new Balls(Arrays.asList(4, 5, 8));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_two_strike() {
        Balls testBalls = new Balls(Arrays.asList(4, 7, 5));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_one_strike_one_ball() {
        Balls testBalls = new Balls(Arrays.asList(4, 6, 5));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_three_strike() {
        Balls testBalls = new Balls(Arrays.asList(4, 7, 6));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isTrue();
    }

    @Test
    void play_three_ball() {
        Balls testBalls = new Balls(Arrays.asList(6, 4, 7));
        PlayResult result = answers.play(testBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(1, 8));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = answers.play(new Ball(1, 7));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
