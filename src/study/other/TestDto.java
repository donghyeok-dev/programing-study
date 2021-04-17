package study.other;

public class TestDto {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String message(String msg) {
        return "hey! " + msg;
    }
}
