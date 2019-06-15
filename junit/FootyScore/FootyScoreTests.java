package junit.FootyScore;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FootyScoreTests {
    final int pointsPerGoal = 6;
    final int pointsPerBehind = 1;
    Random random = new Random();

    @Test
    public void testConstructer()
    {
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        assertEquals(0, footyScore.getPoints());
    }

    @Test
    public void testgetPoints(){
        int goalnumbers = random.nextInt(1000);
        int pointnumbers = random.nextInt(1000);
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        int expectedscore = goalnumbers * pointsPerGoal + pointnumbers * pointsPerBehind;
        assertEquals(expectedscore, footyScore.getPoints());
    }
    @Test
    public void testtoString(){
        int goalnumbers = random.nextInt(1000);
        int pointnumbers = random.nextInt(1000);
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        int expectedscore = goalnumbers * pointsPerGoal + pointnumbers * pointsPerBehind;
        assertEquals(Integer.toString(goalnumbers) + ", " + Integer.toString(pointnumbers) + ", " + footyScore.getPoints(), footyScore.toString());
    }

    @Test
    public void testlosing(){
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        junit.FootyScore.FootyScore footyScore1 = new junit.FootyScore.FootyScore();
        int goalnumbers = 999;
        int pointnumbers = 998;
        int goalnumbers1 = 1000;
        int pointnumbers1 = 1000;
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        for (int a = 0; a < goalnumbers1; a++){
            footyScore1.kickGoal();
        }
        for (int a = 0; a < pointnumbers1; a++){
            footyScore1.kickBehind();
        }
        assertEquals(true, footyScore.losing(footyScore1.getPoints()));

    }

    @Test
    public void testdrawming(){
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        junit.FootyScore.FootyScore footyScore1 = new junit.FootyScore.FootyScore();
        int goalnumbers = 1000;
        int pointnumbers = 1000;
        int goalnumbers1 = 1000;
        int pointnumbers1 = 1000;
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        for (int a = 0; a < goalnumbers1; a++){
            footyScore1.kickGoal();
        }
        for (int a = 0; a < pointnumbers1; a++){
            footyScore1.kickBehind();
        }
        assertEquals(false, footyScore.losing(footyScore1.getPoints()));
    }

    @Test
    public void testwining(){
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        junit.FootyScore.FootyScore footyScore1 = new junit.FootyScore.FootyScore();
        int goalnumbers = 1001;
        int pointnumbers = 1002;
        int goalnumbers1 = 1000;
        int pointnumbers1 = 1000;
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        for (int a = 0; a < goalnumbers1; a++){
            footyScore1.kickGoal();
        }
        for (int a = 0; a < pointnumbers1; a++){
            footyScore1.kickBehind();
        }
        assertEquals(false, footyScore.losing(footyScore1.getPoints()));
    }



    @Test
    public void testrandomlosing(){
        //team 1
        int goalnumbers = random.nextInt(1000);
        int pointnumbers = random.nextInt(1000);
        junit.FootyScore.FootyScore footyScore = new junit.FootyScore.FootyScore();
        for (int a = 0; a < goalnumbers; a++){
            footyScore.kickGoal();
        }
        for (int a = 0; a < pointnumbers; a++){
            footyScore.kickBehind();
        }
        int expectedscore = goalnumbers * pointsPerGoal + pointnumbers * pointsPerBehind;

        //team 2

        junit.FootyScore.FootyScore footyScore1 = new junit.FootyScore.FootyScore();
        for (int a = 0; a < 1300; a++){
            footyScore1.kickGoal();
        }
        for (int a = 0; a < 1300; a++){
            footyScore1.kickBehind();
        }
        int expectedscore1 = 1300 * pointsPerGoal + 1300 * pointsPerBehind;
        assertEquals(footyScore.getPoints() < footyScore1.getPoints(), footyScore.losing(footyScore1.getPoints()));
    }
}

