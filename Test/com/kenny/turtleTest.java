package com.kenny;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kenny.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

public class turtleTest {
    Turtle ijapa;
    private SketchPad sketchPad;
    @BeforeEach
    public void setUpIjapa(){
        ijapa = new Turtle();
        sketchPad = new SketchPad(5,5);
    }
    @Test
    public void thereIsATurtle(){
        assertNotNull(ijapa);

    }
    @Test
    public void turtleCanMovePenUpTest(){
        ijapa.penUp();
        assertTrue(ijapa.isPenIsUp());
    }
    @Test
    public void turtleCanMovePenDown(){
        ijapa.penUp();
        assertTrue(ijapa.isPenIsUp());

        ijapa.penDown();
        assertFalse(ijapa.isPenIsUp());
    }
    @Test
    public void turtleCanTurnRight_FacingEastTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanFaceRight_whileFacingSouthTest(){
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }
//    todo turn turtle right facing west and north

    @Test
    public void turtleCanTurnRight_whileFacingWestTest(){
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());


    }
    @Test
    public void turtleCanTurnRight_whileFacingNorthTest(){
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH,ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(EAST,ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_whileFacingEast(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_whileFacingNorth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_whileFacingWest(){
        assertEquals(EAST,ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_whileFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH,ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(EAST, ijapa.getCurrentDirection());
    }

    @Test
    public void turtleCanMoveWhileFacingEastAndPenIsUpTest(){
        assertEquals(new Position(0, 0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0,2), ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMoveWhileFacingEastToSouthTestAndPenIsUp(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,2),ijapa.getCurrentPosition());
    }
    //todo move forward facing all the sides
    @Test
    public void turtleCanMoveWhileFacingWestAndPenIsUp(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,0), ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMoveWhileFacingNorthAndPenIsUp(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3,sketchPad);
        ijapa.turnRight();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2),ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,0), ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());

    }

    @Test
    public void turtleCanWriteWhenPenIsDownFacingEastTest(){
        ijapa.penDown();
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenIsUp());
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingWest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(1,floor[2][0]);
        assertEquals(1,floor[2][1]);
        assertEquals(1,floor[2][2]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingNorth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,0),ijapa.getCurrentPosition());
        assertEquals(1,floor[2][0]);
        assertEquals(1,floor[2][1]);
        assertEquals(1,floor[2][2]);
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(0,0),ijapa.getCurrentPosition());
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[1][0]);
        assertEquals(1,floor[2][0]);
        assertEquals(0,floor[3][0]);
        sketchPad.display();
    }



}
