import com.github.javafaker.Faker;

public class JavaFakertest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.phoneNumber().phoneNumber());
    }
}
