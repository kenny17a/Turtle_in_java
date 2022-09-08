package com.kenny;

public class ArrayPattern {

    private static int[][] display = new int[3][5];
    public static void fillRowA(){
        display[0][0] = 1;
        display[0][1] = 2;
        display[0][2] = 3;
        display[0][3] = 2;
        display[0][4] = 1;
    }
    public static void fillRowB(){
        display[1][0] = 3;
        display[1][1] = 2;
        display[1][2] = 1;
        display[1][3] = 2;
        display[1][4] = 3;
    }

    public static void fillRowC(){
        display[2][0] = 1;
        display[2][1] = 2;
        display[2][2] = 1;
        display[2][3] = 2;
        display[2][4] = 3;
    }
    public static void displayOutput(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (display[i][j] == 1){
                    System.out.print("X");
                } else if (display[i][j] == 2) {
                    System.out.print("|");

                }else{
                    System.out.print("O");
                }


            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        fillRowA();
        fillRowB();
        fillRowC();
        displayOutput();


    }

}

