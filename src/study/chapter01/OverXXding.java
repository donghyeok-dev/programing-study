package study.chapter01;

import study.other.TestDto;

public class OverXXding {

    public static void main(String[] args) {
        Parent parent = new Parent("tiger");
        Child child = new Child("lion");

        //오버라이드(Override)
        System.out.println(parent.getAnimal());
        System.out.println(child.getAnimal());

        //오버로딩(Overloading)
        child.setAnimal("Elephant");
        child.setAnimal("Elephant", 20);
        System.out.println(child.setAnimal("Elephant", 20, "아프리카"));
    }
}

class Parent {
    protected String name;
    protected Integer age;
    protected String location;

    public Parent(String name) {
        this.name = name;
    }
    public void setAnimal(String name) {
        this.name = name;
    }

    public void setAnimal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public int setAnimal(String name, Integer age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;

        return 1;
    }

    public String getAnimal() {
        return this.name;
    }
}

class Child extends Parent{

    public Child(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getAnimal() {
        return "name: " + this.name + " age: " + this.age + " location: " + this.location;
    }
}
