import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void instantiateRobotFacingNorthWithCoordinatesX3Y4() {
        Rover rover = new Rover(3, 4, "N");

        int xPos = rover.getXPosition();
        int yPos = rover.getYPosition();

        String heading = rover.getHeading();

        assertEquals(xPos, 3);
        assertEquals(yPos, 4);
        assertEquals("N", heading);
    }

    @Test
    public void instantiateRobotFacingSouthWithCoordinatesX9Y9() {
        Rover rover = new Rover(9, 9, "S");

        int xPos = rover.getXPosition();
        int yPos = rover.getYPosition();

        String heading = rover.getHeading();

        assertEquals(xPos, 9);
        assertEquals(yPos, 9);
        assertEquals("S", heading);
    }

    @Test
    public void instantiateRobotFacingEastWithCoordinatesX5Y0() {
        Rover rover = new Rover(5, 0, "E");

        int xPos = rover.getXPosition();
        int yPos = rover.getYPosition();

        String heading = rover.getHeading();

        assertEquals(5, xPos);
        assertEquals(0, yPos);
        assertEquals("E", heading);
    }

    @Test
    public void instantiateRobotFacingWestWithCoordinatesX5Y15() {
        Rover rover = new Rover(5, 15, "W");

        int xPos = rover.getXPosition();
        int yPos = rover.getYPosition();

        String heading = rover.getHeading();

        assertEquals(5, xPos);
        assertEquals(15, yPos);
        assertEquals("W", heading);
    }

    @Test
    public void instantiateRobotFacingNorthAndTurnRight() {
        Rover rover = new Rover(5, 15, "N");

        String heading = rover.getHeading();
        assertEquals("N", heading);
        rover.turnRight();
        heading = rover.getHeading();
        assertEquals("E", heading);
        rover.turnRight();
        heading = rover.getHeading();
        assertEquals("S", heading);
        rover.turnRight();
        heading = rover.getHeading();
        assertEquals("W", heading);
        rover.turnRight();
        heading = rover.getHeading();
        assertEquals("N", heading);
    }

    @Test
    public void instantiateRobotFacingNorthAndTurnLeft() {
        Rover rover = new Rover(5, 15, "N");

        String heading = rover.getHeading();
        assertEquals("N", heading);
        rover.turnLeft();
        heading = rover.getHeading();
        assertEquals("W", heading);
        rover.turnLeft();
        heading = rover.getHeading();
        assertEquals("S", heading);
        rover.turnLeft();
        heading = rover.getHeading();
        assertEquals("E", heading);
        rover.turnLeft();
        heading = rover.getHeading();
        assertEquals("N", heading) ;
    }

    @Test
    public void instantiateRobotFacingNorthAndMoveForwardByOne() {
        Rover rover = new Rover(5, 15, "N");

        String heading = rover.getHeading();
        assertEquals(heading, "N");
        rover.moveForward();
        int xPosition = rover.getXPosition();
        int yPosition = rover.getYPosition();
        assertEquals(16, yPosition);
        assertEquals(5, xPosition);
    }

    @Test
    public void instantiateRobotFacingEastAndMoveForwardByOne() {
        Rover rover = new Rover(5, 15, "E");

        String heading = rover.getHeading();
        assertEquals(heading, "E");
        rover.moveForward();
        int xPosition = rover.getXPosition();
        int yPosition = rover.getYPosition();
        assertEquals(15, yPosition);
        assertEquals(6, xPosition);
    }

    @Test
    public void instantiateRobotFacingSouthAndMoveForwardByOne() {
        Rover rover = new Rover(5, 15, "S");

        String heading = rover.getHeading();
        assertEquals(heading, "S");
        rover.moveForward();
        int xPosition = rover.getXPosition();
        int yPosition = rover.getYPosition();
        assertEquals(14, yPosition);
        assertEquals(5, xPosition);
    }

    @Test
    public void instantiateRobotFacingWestAndMoveForwardByOne() {
        Rover rover = new Rover(5, 15, "W");

        String heading = rover.getHeading();
        assertEquals(heading, "W");
        rover.moveForward();
        int xPosition = rover.getXPosition();
        int yPosition = rover.getYPosition();
        assertEquals(15, yPosition);
        assertEquals(4, xPosition);
    }
}