package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    /*
    TEST DATA:username,password,URL,test environment,address etc...
    Where do you get your test data?
    BA-Business Analyst
    Test Lead
    Manual tester
    Developer
    From database
    From API(documentation)
    Mock data(fake data)-->Java Faker
    (Java Faker creates data randomly

     */
    @Test
    public void javaFakerTest(){
        //1st step: Create Faker Object
        Faker faker=new Faker();

        //2nd step: Create fake data
        //generating firstname
        String firstName= faker.name().firstName();
        System.out.println(firstName);

        //generating lastname
        String lastName= faker.name().lastName();
        System.out.println(lastName);

        //generating username
        String userName= faker.name().username();
        System.out.println(userName);

        //generating title
        String title= faker.name().title();
        System.out.println(title);

        //generating full address
        String fullAddress= faker.address().fullAddress();
        System.out.println(fullAddress);

        //phone number
        String cellPhone= faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

        //numberBetween
        Integer numberBetween= faker.number().numberBetween(1,5);
        System.out.println(numberBetween);
    }
}
