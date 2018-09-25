import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarsTest {

    @Test
    public void onInstantiationCheckTileAtPositionZeroZeroIsNotNullAndSafe() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(0,0);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionZeroTenIsNotNullAndSafe() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(0,10);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionFourtyNineFourtyNineIsNotNullAndSafe() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(49,49);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtPositionTenTenIsNotNullAndSafe() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(10,10);
        assertNotNull(t);
        assertEquals(true, t.getSafetyStatus());
    }

    @Test
    public void onInstantiationCheckTileAtMinusTenTenReturnsNull() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(-10,10);
        assertNull(t);
    }

    @Test
    public void onInstantiationCheckTileAtSixtySixtyReturnsNull() {
        Mars mars = new Mars();
        mars.setupGrid(50);

        Tile t = mars.getTileFromCoordinate(60,60);
        assertNull(t);
    }
}