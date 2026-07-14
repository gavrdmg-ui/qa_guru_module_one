package utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataGeneratorUtils {

    private final Faker faker = new Faker();
    private static final List<String> genderList = List.of("Male", "Female", "Other");
    private static final List<String> hobbiesList = List.of("Sports", "Reading", "Music");
    private final String[][] months = {
            {"January", "Jan"},
            {"February", "Feb"},
            {"March", "Mar"},
            {"April", "Apr"},
            {"May", "May"},
            {"June", "Jun"},
            {"July", "Jul"},
            {"August", "Aug "},
            {"September", "Sep"},
            {"October", "Oct"},
            {"November", "Nov"},
            {"December", "Dec"}};
    private static final List<String> subjectsList = List.of(
            "Maths",
            "Physics",
            "Chemistry",
            "Biology",
            "English",
            "Computer Science",
            "Economics", "Arts",
            "History",
            "Civics",
            "Hindi");
    private static final Map<String, String[]> stateAndCities = Map.ofEntries(
            Map.entry("NCR", new String[]{"Delhi", "Gurgaon", "Noida"}),
            Map.entry("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"}),
            Map.entry("Haryana", new String[]{"Karnal", "Panipat"}),
            Map.entry("Rajasthan", new String[]{"Jaipur", "Jaiselmer"}));
    private final List<String> stateList = new ArrayList<>(stateAndCities.keySet());

    public String getState() {

        return faker.options().nextElement(this.stateList);
    }

    public String getCity(String state) {
        return faker.options().nextElement(stateAndCities.get(state));
    }

    public String getHobbies() {
        return faker.options().nextElement(hobbiesList);
    }

    public String getGender() {
        return faker.options().nextElement(genderList);
    }

    public String getSubject() {
        return faker.options().nextElement(subjectsList);
    }

    public String[] getMonths() {
        return this.months[faker.number().numberBetween(0, this.months.length - 1)];
    }
}
