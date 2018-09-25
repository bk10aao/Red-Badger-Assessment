public class Rover {

    private boolean NORTH = false;
    private boolean EAST = false;
    private boolean SOUTH = false;
    private boolean WEST = false;

    private int xPosition;
    private int yPosition;

    public Rover(int x, int y, String heading) {
        if(heading.equalsIgnoreCase("N"))
            NORTH = true;
        if(heading.equalsIgnoreCase("E"))
            EAST = true;
        if(heading.equalsIgnoreCase("S"))
            SOUTH = true;
        if(heading.equalsIgnoreCase("W"))
            WEST = true;

        this.xPosition = x;
        this.yPosition = y;
    }

    public void turnLeft() {
        if(NORTH) {
            NORTH = false;
            WEST = true;
        } else if(WEST) {
            WEST = false;
            SOUTH = true;
        } else if(SOUTH) {
            SOUTH = false;
            EAST = true;
        } else if(EAST) {
            EAST = false;
            NORTH = true;
        }
    }

    public void turnRight() {
        if(NORTH) {
            NORTH = false;
            EAST = true;
        } else if(EAST) {
            EAST = false;
            SOUTH = true;
        } else if(SOUTH) {
            SOUTH = false;
            WEST = true;
        } else if(WEST) {
            WEST = false;
            NORTH = true;
        }
    }

    public void moveForward() {
        if(NORTH) {
            yPosition++;
        } else if(EAST) {
            xPosition++;
        } else if(SOUTH) {
            yPosition--;
        } else if(WEST) {
            xPosition--;
        }
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public String getHeading() {
        if(NORTH) {
            return "N";
        } else if(EAST) {
            return "E";
        } else if(SOUTH) {
            return "S";
        } else {
            return "W";
        }
    }
}
