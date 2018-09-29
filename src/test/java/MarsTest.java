import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarsTest {

    @Test
    public void onInstantiationCheckTileAtPositionZeroZeroIsNotNullAndSafe() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(0,0);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionZeroTenIsNotNullAndSafe() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(0,10);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionFourtyNineFourtyNineIsNotNullAndSafe() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(49,49);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionTenTenIsNotNullAndSafe() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(10,10);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtMinusTenTenReturnsNull() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(-10,10);
        assertNull(t);
    }

    @Test
    public void onInstantiationCheckTileAtSixtySixtyReturnsNull() {
        Mars mars = new Mars(50, 50);

        Tile t = mars.getTileFromCoordinate(60,60);
        assertNull(t);
    }

    @Test
    public void inputReturnsRoverOnCoordinatesXOneYOneFacingEast() {
        Mars mars = new Mars(5, 3);

        String result = mars.executeInstructions("1 1 E", "RFRFRFRF");
        assertEquals("1 1 E", result);
    }

    @Test
    public void inputReturnsRoverOnCoordinatesXThreeYThreeFacingNorthAndLost() {
        Mars mars = new Mars(5, 3);

        String result = mars.executeInstructions("3 2 N", "FRRFLLFFRRFLL");
        assertEquals("3 3 N LOST", result);

        boolean tileWhichShouldBeUnsafe = mars.getTileFromCoordinate(3,3).getSafetyStatus();
        assertEquals(false, tileWhichShouldBeUnsafe);

        boolean tileWhichShouldBeSafe = mars.getTileFromCoordinate(1,1).getSafetyStatus();
        assertEquals(true, tileWhichShouldBeSafe);

        String unsafeLocations = mars.getUnsafeTileLocations();
        assertEquals("Unsafe Tiles: (3, 3)", unsafeLocations);
    }

    @Ignore
    @Test
    public void inputReturnsRoverOnCoordinatesXTwoYThreeFacingSouth() {
        Mars mars = new Mars(5, 3);

        String result = mars.executeInstructions("0 3 W", "LLFFFLFLFL");
        assertEquals("2 3 S", result);
    }

    @Test
    public void testThatBotDoesNotMoveOntoTileThatHasPreviouslyLostARobot() {
        Mars mars = new Mars(5, 3);

        String result = mars.executeInstructions("0 3 N", "F");
        assertEquals("0 4 N LOST", result);

        result = mars.executeInstructions("0 2 N", "F");
        assertEquals("0 2 N", result);

        String unsafeLocations = mars.getUnsafeTileLocations();
        assertEquals("Unsafe Tiles: (0, 3)", unsafeLocations);
    }

    @Test
    public void testThatBotDoesNotMoveOntoTileThatHasPreviouslyLostARobotButThenPerformsFurtherActions() {
        Mars mars = new Mars(5, 3);

        String result = mars.executeInstructions("0 3 N", "F");
        assertEquals("0 4 N LOST", result);

        result = mars.executeInstructions("0 2 N", "FRF");
        assertEquals("1 2 E", result);

        String unsafeLocations = mars.getUnsafeTileLocations();
        assertEquals("Unsafe Tiles: (0, 3)", unsafeLocations);
    }


    @Test
    public void inputReturnsStringInstructionsTooLongMaximumSize100() {
        String moves = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";

        Mars mars = new Mars(5, 3);
        String result = mars.executeInstructions("0 3 W", moves);
        assertEquals("Instructions too long, maximum size 100", result);
    }
}