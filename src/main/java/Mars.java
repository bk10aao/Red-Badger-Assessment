public class Mars {

    private Tile[][] worldMap;

    private int maxXPosition;
    private int maxYPosition;

    private Rover rover;

    public static void main(String[] args) {

    }

    public Mars (int x, int y) {
        setupGrid(x, y);
    }

    private void setupGrid(int sizeX, int sizeY) {
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

    public boolean nextTileIsSafe() {
        try {
            if(rover.getHeading().equalsIgnoreCase("N")) {
                Tile t = worldMap[rover.getXPosition()][rover.getYPosition() + 1];
                return t.getSafetyStatus();
            } else if (rover.getHeading().equalsIgnoreCase("E")) {
                Tile t = worldMap[rover.getXPosition() + 1][rover.getYPosition()];
                return t.getSafetyStatus();
            } else if(rover.getHeading().equalsIgnoreCase("S")) {
                Tile t = worldMap[rover.getXPosition()][rover.getYPosition() - 1];
                return t.getSafetyStatus();
            } else if(rover.getHeading().equalsIgnoreCase("W")) {
                Tile t = worldMap[rover.getXPosition() - 1][rover.getYPosition()];
                return t.getSafetyStatus();
            }
        } catch (IndexOutOfBoundsException e) {
            //is at the edge of the world so we will return true so current tile will be set to unsafe
        }
        return true;
    }

    public String executeInstructions(String startPosition, String movements) {
        rover = createRover(startPosition);
        System.out.println(rover.getPosition());
        String lost = "";
        if(movements.split("").length >= 100) {
            return "Instructions too long, maximum size 100";
        } else {
            for (String s : movements.split("")) {
                int roverXCoordinate = rover.getXPosition();
                int roverYCoordinate = rover.getYPosition();
                if(s.equalsIgnoreCase("F")) {
                    if(nextTileIsSafe() || !lost.isEmpty()) {
                        rover.move(s);
                    }
                } else {
                    rover.move(s);
                }
                lost = checkIfRoverIsLost(lost, roverXCoordinate, roverYCoordinate);
                System.out.println(s + ": " + rover.getPosition() + lost);
            }
        }
        return rover.getPosition() + lost;
    }

    private String checkIfRoverIsLost(String lost, int roverXCoordinate, int roverYCoordinate) {
        if ((rover.getXPosition() < 0 || rover.getXPosition() > maxXPosition) ||
            (rover.getYPosition() < 0 || rover.getYPosition() > maxYPosition)) {
            try {
                worldMap[roverXCoordinate][roverYCoordinate].setUnsafe();
                lost = " LOST";
            } catch (Exception e) {
                //already out of bounds so will cause exception so do nothing
            }
        }
        return lost;
    }

    public String getUnsafeTileLocations() {
        String unsafeLocations = "Unsafe Tiles:";
        for(int x = 0; x <= maxXPosition; x++) {
            for(int y = 0; y <= maxYPosition; y++) {
                if(!worldMap[x][y].getSafetyStatus()) {
                    unsafeLocations += " (" + x + ", " + y + ")";
                }
            }
        }
        System.out.println(unsafeLocations);
        return unsafeLocations;
    }

    private Rover createRover(String startPosition) {
        String[] startPointValues = startPosition.split("\n")[0].split(" ");
        int startPositionX = Integer.parseInt(startPointValues[0]);
        int startPositionY = Integer.parseInt(startPointValues[1]);
        String heading = startPointValues[2];
        return new Rover(startPositionX, startPositionY, heading);
    }
}
