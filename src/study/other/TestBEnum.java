package study.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum TestBEnum implements CommonEnum{
    COMPUTER("CP", "컴퓨터"),
    PHONE("PH", "휴대폰");

    private String code;
    private String codeName;

    TestBEnum(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }
}
