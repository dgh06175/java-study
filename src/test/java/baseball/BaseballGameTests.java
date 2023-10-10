package baseball;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BaseballGameTests {
    BaseballGame b = new BaseballGame();
    @Test
    @DisplayName("컴퓨터 생성 수 유효성 검사")
    void checkComputerNumber() {
        List<Integer> result = b.initComputerNumber();
        List<Integer> correctNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertThat(correctNumbers).containsAll(result);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void inputGameContinue_재시작_검사() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertThat(b.inputGameContinue()).isEqualTo(true);

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertThat(b.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("-421".getBytes()));
        assertThat(b.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("23".getBytes()));
        assertThat(b.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("asd".getBytes()));
        assertThatThrownBy(() -> b.inputGameContinue())
                .isInstanceOf(InputMismatchException.class);
    }
}
