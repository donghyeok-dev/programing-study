package study.other;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.EnumSet;

@RequiredArgsConstructor
public class EnumTest<T extends Enum<T> & CommonEnum> {
    private final Class<T> targetEnumClass;

    public CommonEnum getCodeName(String code) {
        return EnumSet.allOf(this.targetEnumClass).stream()
                .filter(testEnum -> testEnum.getCode().equals(code))
                .findAny()
                .orElseThrow();
    }

    public static String getCode(CommonEnum enumValue) {
        return enumValue.getCode();
    }
}
