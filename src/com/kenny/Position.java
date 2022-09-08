package com.kenny;

public class Position {
    private int row;
    private int column;
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }
    @Override
    public String toString(){
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                "}";
    }


    @Override
    public boolean equals(Object obj){
        if (!obj.getClass().equals(this.getClass())) return false;
        Position comparedPosition = (Position) obj;
        boolean rowsAreEqual = comparedPosition.row == this.row;
        boolean columnAreEqual = comparedPosition.column == this.column;
        return rowsAreEqual && columnAreEqual;
    }

    public int getColumn(){
        return column;
    }
    public void setColumn(int column){
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int newRow) {
        row = newRow;
    }
}
