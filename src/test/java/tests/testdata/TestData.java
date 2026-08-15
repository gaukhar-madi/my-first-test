package tests.testdata;


import java.util.Locale;
import com.github.javafaker.Faker;

public class TestData {

    private final Faker faker = new Faker();
    private final Faker fakerRu = new Faker(new Locale("ru"));

    public String firstName = fakerRu.name().firstName();
    public String lastName = fakerRu.name().lastName();

    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = fakerRu.address().fullAddress();
    public String permanentAddress = fakerRu.address().fullAddress();
    public String gender = faker.options().option("Female", "Male", "Other");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String birthDay = String.valueOf(faker.number().numberBetween(1, 28));
    public String birthMonth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public String birthYear = String.valueOf(faker.number().numberBetween(1980, 2000));
    public String subject = faker.options().option(
            "Maths", "Chemistry", "Biology", "History", "Physics"
    );
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picture = "hailey-baldwin.jpg";
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = generateCity(state);

    private String generateCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "";
        }
    }

    public static String incorrectEmail = "michael.thomas@gmail";
    public static String incorrectPhoneNumber = "747220770";
}

//    public static String firstName = "Michael";
//    public static String lastName = "Thomas";
//    public static String userEmail = "michael.thomas@gmail.com";
//    public static String incorrectEmail = "michael.thomas@gmail";
//    public static String gender = "Male";
//    public static String phoneNumber = "7472207702";
//    public static String incorrectPhoneNumber = "747220770";
//    public static String birthYear = "1993";
//    public static String birthMonth = "June";
//    public static String birthDay = "7";
//    public static String currentAddress = "First Avenue 1";
//    public static String permanentAddress = "Second Avenue 2";
//    public static String subject = "Math";
//    public static String hobby = "Music";
//    public static String picture = "hailey-baldwin.jpg";
//    public static String state = "Rajasthan";
//    public static String city = "Jaipur";
