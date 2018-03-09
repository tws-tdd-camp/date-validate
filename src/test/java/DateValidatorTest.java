import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Executable;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/***
 * 某程序具有如下功能：文本框要求输入日期信息，
 * 日期限定在1990年1月~2049年12月，
 * 并规定日期由6位数字字符组成，前4位表示年，后2位表示月；
 * 程序需对输入的日期有效性进行校验。
 */

class DateValidatorTest {

    private boolean validate(String date) {
        if(date.isEmpty()) {
            return false;
        }

        Integer intDate = Integer.valueOf(date);

        if(intDate < 199001 || intDate > 204912) {
            throw new IllegalArgumentException("validate date");
        }

        return true;
    }

    @Test
    void should_return_true_if_data_is_correct() {
        assertThat(validate("")).isFalse();
    }

    @TestFactory
    Stream<DynamicTest> should_return_false_if_data_is_correct() {
        List<String> dateStrList = Arrays.asList(
                "199001",
                "204912"
        );

        return dateStrList.stream().map((str) -> {
            return dynamicTest("should_return_true_if_date_is_" + str, ()-> {
                assertThat(validate(str)).isTrue();
            });
        });
    }

    @TestFactory
    Stream<DynamicTest> should_throw_exception_when_data_is_illegal() {

        List<String> dateStrList = Arrays.asList(
                "198901",
                "205001"
        );

        return dateStrList.stream().map((str)-> {
            return dynamicTest("should_throw_exception_when_data_is_" + str, ()-> {
                assertThrows(IllegalArgumentException.class, ()-> validate(str));
            });

        });

    }
}


