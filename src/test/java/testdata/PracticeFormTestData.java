package testdata;

import java.util.List;
import java.util.Map;

public class PracticeFormTestData {
    public static String firstName = "Test";
    public static String lastName = "Testov";
    public static String userEmail = "testing@mail.com";
    public static String gender = "Male";
    public static String mobilePhoneNumber = "7923858192";
    public static String uncorrectMobilePhoneNumber="7923";
    public static String birthMonth = "August";
    public static String birthYear = "1999";
    public static String birthDay = "27";
    public static String subject = "Computer Science";
    public static List<String> hobbies = List.of("Sports", "Music");
    public static String uploadPicture = "Cat.jpg";
    public static String currentAddress = "Улица Пушкина, дом Колотушкина, квартира Вампиров, №3";
    public static String state = "Uttar Pradesh";
    public static String city = "Lucknow";
    public static String formError="Please fill required fields and enter a valid 10-digit mobile number.";
    public static Map<String, String> months = Map.ofEntries(
            Map.entry("January", "Jan"),
            Map.entry("February", "Feb"),
            Map.entry("March", "Mar"),
            Map.entry("April", "Apr"),
            Map.entry("May", "May"),
            Map.entry("June", "Jun"),
            Map.entry("July", "Jul"),
            Map.entry("August", "Aug "),
            Map.entry("September", "Sep"),
            Map.entry("October", "Oct"),
            Map.entry("November", "Nov"),
            Map.entry("December", "Dec")
    );
}
