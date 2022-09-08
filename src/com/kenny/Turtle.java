package com.kenny;

import static com.kenny.Direction.*;

public class Turtle {
    private boolean penIsUp;
    private Direction currentDirection = EAST;
    private Position currentPosition = new Position(0, 0);

    public void penUp() {
        penIsUp = true;
    }

    public boolean isPenIsUp() {
        return penIsUp;
    }

    public void penDown() {
        penIsUp = false;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnRight() {
        if (currentDirection == EAST) face(SOUTH);
        else if (currentDirection == SOUTH) face(WEST);
        else if (currentDirection == WEST) face(NORTH);
        else if (currentDirection == NORTH) face(EAST);
    }

    private void face(Direction newDirection) {
        currentDirection = newDirection;
    }

    public void turnLeft() {
        if (currentDirection == EAST) face(NORTH);
        else if (currentDirection == NORTH) face(WEST);
        else if (currentDirection == WEST) face(SOUTH);
        else if (currentDirection == SOUTH) face(EAST);

    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    private void move(int noOfSteps) {
        if (currentDirection == EAST) eastMovement(noOfSteps);
        if (currentDirection == WEST) westMovement(noOfSteps);
        if (currentDirection == SOUTH) southMovement(noOfSteps);
        if (currentDirection == NORTH) northMovement(noOfSteps);

    }

    private void northMovement(int noOfSteps) {
        int newRow = currentPosition.getRow() - noOfSteps;
        currentPosition.setRow(newRow);
    }

    private void southMovement(int noOfSteps) {
        int newRow = currentPosition.getRow() + noOfSteps;
        currentPosition.setRow(newRow);
    }

    private void westMovement(int noOfSteps) {
        int newColumn = currentPosition.getColumn() - noOfSteps;
        currentPosition.setColumn(newColumn);
    }

    private void eastMovement(int noOfSteps) {
        int newColumn = currentPosition.getColumn() + noOfSteps;
        currentPosition.setColumn(newColumn);
    }

    public void move(int noOfSteps, SketchPad sketchPad) {
        noOfSteps = noOfSteps - 1;
        if (!penIsUp) writeOn(sketchPad, noOfSteps);
        move(noOfSteps);
    }

    private void writeOn(SketchPad sketchPad, int noOfSteps) {
        var floor = sketchPad.getFloor();
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();
        if (currentDirection == EAST) {
            for (int i = 0; i <= noOfSteps; i++) {
                floor[currentRow][currentColumn++] = 1;
            }

//            floor[currentRow][currentColumn++] = 1;
//            floor[currentRow][currentColumn] = 1;
        }
        if (currentDirection == SOUTH) {
            for (int i = 0; i <= noOfSteps; i++) {
                floor[currentRow++][currentColumn] = 1;
            }
        }
        if (currentDirection == WEST) {
            for (int i = 0; i < noOfSteps; i++) {
                floor[currentRow][--currentColumn] = 1;
            }
        }
        if (currentDirection == NORTH) {
            for (int i = 0; i < noOfSteps; i++) {
                floor[--currentRow][currentColumn] = 1;
            }
        }
    }
}