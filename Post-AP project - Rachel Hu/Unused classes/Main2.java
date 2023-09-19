/**
 * haha how do you code again
 * 
 * 2nd try at making conway's game of life because I went crazy on the first one
 */

public class Main2
{
    public static void main(String[] args)
    {
        CellArray test = new CellArray();

        test.changeState(2,0);
        test.changeState(1,2);
        test.changeState(2,2);
        test.changeState(3,2);
        test.changeState(3,1);

        System.out.println("ORIGINAL: ");
        for (int row = 0; row < test.numRows; row ++)
        {
            for (int column = 0; column < test.numCols; column ++)
            {
                if (test.cellArray[row][column]) {System.out.print("O ");}
                else {System.out.print("- ");}
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        test.run(1);
    }
}