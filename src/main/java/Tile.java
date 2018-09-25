public class Tile {

    private boolean isSafe = true;

    public void setUnsafe() {
        this.isSafe = false;
    }

    public boolean getSafetyStatus() {
        return this.isSafe;
    }

}
