public class Mars {

    private Tile[][] worldMap;

    public static void main(String[] args) {

    }

    public void setupGrid(int size) {
        worldMap = new Tile[size][size];
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                worldMap[x][y] = new Tile();
            }
        }
    }

    public Tile getTileFromCoordinate(int x, int y) {
        if(x < worldMap.length && y < worldMap[0].length && x >= 0  && y >= 0) {
            return worldMap[x][y];
        } else {
            return null;
        }
    }
}
