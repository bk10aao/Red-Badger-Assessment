public class Mars {

    private Tile[][] worldMap;

    private int maxXPosition;
    private int maxYPosition;

    private Rover rover;

    public static void main(String[] args) {

    }

    public void setupGrid(int sizeX, int sizeY) {
        worldMap = new Tile[sizeX + 1][sizeY + 1];
        maxXPosition = sizeX;
        maxYPosition = sizeY;
        for(int x = 0; x <= sizeX; x++) {
            for(int y = 0; y <= sizeY; y++) {
                worldMap[x][y] = new Tile();
            }
        }
    }

    public Tile getTileFromCoordinate(int x, int y) {
        if(x <= worldMap.length && y <= worldMap[0].length && x >= 0  && y >= 0) {
            return worldMap[x][y];
        } else {
            return null;
        }
    }

    public String executeInstructions(String startPosition, String movements) {
        rover = createRover(startPosition);
        System.out.println(rover.getPosition());
        String lost = "";
        for(String s: movements.split("")) {
            int roverXCoordinate = rover.getXPosition();
            int roverYCoordinate = rover.getYPosition();
            rover.move(s);
            if((rover.getXPosition() < 0 || rover.getXPosition() > maxXPosition) ||
               (rover.getYPosition() < 0 || rover.getYPosition() > maxYPosition)) {
                try {
                    worldMap[roverXCoordinate][roverYCoordinate].setUnsafe();
                } catch (Exception e) {
                    //already out of bounds so will cause exception so do nothing
                }
                lost = " LOST";
            }
            System.out.println(s + ": " + rover.getPosition() + lost);
        }
        return rover.getPosition() + lost;
    }

    private Rover createRover(String startPosition) {
        String[] startPointValues = startPosition.split("\n")[0].split(" ");
        int startPositionX = Integer.parseInt(startPointValues[0]);
        int startPositionY = Integer.parseInt(startPointValues[1]);
        String heading = startPointValues[2];
        return new Rover(startPositionX, startPositionY, heading);
    }
}
