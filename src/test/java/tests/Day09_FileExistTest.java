package tests;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
    /*
    Given
        Create a file on desktop
    When
        Copy the path of file
    Then
        Assert if the file exists
    */

    //file path: "/Users/gulcin/Desktop/file2.txt"

    @Test

    public void isExistTest(){

        //System.out.println(System.getProperty("user.dir")); //getting the current project folder directory /Users/gulcin/IdeaProjects/SeleniumNewProject
        String userHome=System.getProperty("user.home");
        System.out.println(userHome);

        //Assert if the file exist
        boolean isExist=Files.exists(Paths.get(userHome+"/Desktop/file2.txt")); //writing the path dynamically so, it can work on other pcs.
        assertTrue(isExist);
    }

}
