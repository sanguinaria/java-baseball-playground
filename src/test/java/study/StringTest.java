package study;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split()    {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split_single() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring_parentheses()    {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다")
    void charAt()   {
        String value = "abc";
        int position = new Random().nextInt(value.length() - 1);
        char actual = value.charAt(position);
        assertThat(actual).isEqualTo(value.toCharArray()[position]);
    }

    @Test
    @DisplayName("위치 값을 벗어나면 예외 발생")
    void charAt_out_of_range()   {
        String value = "abc";
        int position = new Random().nextInt() + value.length();
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char actual = value.charAt(position);
            });
    }


}
