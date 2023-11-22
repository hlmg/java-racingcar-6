package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class NameTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            '   ', 자동차 이름은 비어있을 수 없습니다
            ' a', 자동차 이름 양 옆에 공백이 올 수 없습니다
            'a ', 자동차 이름 양 옆에 공백이 올 수 없습니다
            123456, 자동차 이름은 5자 이하여야 합니다
            """)
    void 자동차_이름을_검증할_수_있다(String name, String message) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.from(name))
                .withMessage(message);
    }
}
