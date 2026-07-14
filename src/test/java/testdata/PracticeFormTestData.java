package testdata;

import com.github.javafaker.Faker;
import utils.TestDataGeneratorUtils;

public class PracticeFormTestData {

    private final Faker faker = new Faker();
    private final TestDataGeneratorUtils dataGenerator = new TestDataGeneratorUtils();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = dataGenerator.getGender();
    public String mobilePhoneNumber = faker.number().digits(10);
    public String uncorrectMobilePhoneNumber = String.valueOf(faker.number().numberBetween(111, 999));
    public String[] birthMonth = dataGenerator.getMonths();
    public String birthYear = String.valueOf(faker.number().numberBetween(1936, 2026));
    public String birthDay = String.valueOf(faker.number().numberBetween(1, 31));
    public String subject = dataGenerator.getSubject();
    public String hobbies = dataGenerator.getHobbies();
    public String uploadPicture = "Cat.jpg";
    public String currentAddress = faker.address().fullAddress();
    public String state = dataGenerator.getState();
    public String city = dataGenerator.getCity(state);
    public String formError = "Please fill required fields and enter a valid 10-digit mobile number.";
}
