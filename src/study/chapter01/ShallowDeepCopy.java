package study.chapter01;

public class ShallowDeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book("스프링", 10000);
        Book book2 = book1; //Shallow Copy(얕은 복사)

        book2.setAmount(15000);
        System.out.println(book1); //스프링 15000
        System.out.println(book2); //스프링 15000

        Book book3 = book1.clone(); //Deep Copy(깊은 복사)

        book3.setAmount(25000);
        System.out.println(book1); //스프링 15000
        System.out.println(book3); //스프링 25000

    }
}

class Book implements Cloneable {
    String name;
    int amount;

    public Book(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    @Override
    public String toString() {
        return this.name + " " + this.amount;
    }
}
