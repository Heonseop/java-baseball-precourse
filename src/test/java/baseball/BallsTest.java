package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {
    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(4, 7, 6));
    }

    @Test
    void play_nothing() {
        PlayResult result = answers.play(Arrays.asList(9, 1, 2));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_one_strike() {
        PlayResult result = answers.play(Arrays.asList(4, 5, 8));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_two_strike() {
        PlayResult result = answers.play(Arrays.asList(4, 7, 5));
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_one_strike_one_ball() {
        PlayResult result = answers.play(Arrays.asList(4, 6, 5));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.isEndGame()).isFalse();
    }

    @Test
    void play_three_strike() {
        PlayResult result = answers.play(Arrays.asList(4, 7, 6));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEndGame()).isTrue();
    }

    @Test
    void play_three_ball() {
        PlayResult result = answers.play(Arrays.asList(6, 4, 7));
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
