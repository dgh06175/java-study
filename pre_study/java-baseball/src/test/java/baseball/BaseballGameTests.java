package baseball;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BaseballGameTests {
    BaseballGame b = new BaseballGame();
    List<String> result = b.initComputerNumber();

    @Test
    @DisplayName("컴퓨터 생성 수 유효성 검사")
    void checkComputerNumber() {
        List<String> correctNumbers = new ArrayList<>(List.of("123456789".split("")));
        assertThat(correctNumbers).containsAll(result);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_생성_수_중복_검사() {
        boolean isSameNum = result.get(0).equals(result.get(1));
        if (result.get(0).equals(result.get(2))) isSameNum = true;
        if (result.get(1).equals(result.get(2))) isSameNum = true;
        assertThat(isSameNum).isEqualTo(false);
    }

    @Test
    void 재시작_입력_기능_검사() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertThat(Application.inputGameContinue()).isEqualTo(true);

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertThat(Application.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("-421".getBytes()));
        assertThat(Application.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("23".getBytes()));
        assertThat(Application.inputGameContinue()).isEqualTo(false);

        System.setIn(new ByteArrayInputStream("asd".getBytes()));
        assertThatThrownBy(Application::inputGameContinue)
                .isInstanceOf(InputMismatchException.class);
    }

    @Test
    void 유저_입력_숫자_검사() {
        System.setIn(new ByteArrayInputStream("289".getBytes()));
        assertThat(b.initUserNumber()).isEqualTo(new ArrayList<>(List.of("2", "8", "9")));
    }
}
