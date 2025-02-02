package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {
    private val sut = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2", "10", "5 + 5"])
    fun `문자열을 입력받아 계산을 할 수 있다`(formula: String) {
        // given
        // when
        val result = sut.calculate(formula)

        // then
        assertThat(result).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "1)2", "1 / 0"])
    fun `입력값이 유효하지 않다면 IllegalArgumentException 가 발생한다`(invalidFormula: String) {
        // given

        // when
        // then
        assertThatThrownBy {
            sut.calculate(invalidFormula)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
