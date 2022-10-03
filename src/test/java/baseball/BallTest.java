package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(1, 7);
    }

    @Test
    void nothing() {
        assertThat(computer.play(new Ball(2, 3))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(computer.play(new Ball(2, 7))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(computer.play(new Ball(1, 7))).isEqualTo(BallStatus.STRIKE);
    }
}
