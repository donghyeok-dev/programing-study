package study.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum TestEnum implements CommonEnum{
    KOREA("KR", "대한민국"),
    USA("US", "미국"),
    JAPAN("JP", "일본");

    private String code;
    private String codeName;

    TestEnum(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }
}
