
import java.util.Scanner;

public class matrix {
    public double distaneCount(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    double travelDistance = 0;
    Scanner scanner = new Scanner(System.in);

    public void createMatrix() {
        System.out.println("How many points you want to visit? ");
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][2];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Insert coordinates for point " + (i + 1) + " X: ");
            matrix[i][0] = scanner.nextInt();
            System.out.println("Y: ");
            matrix[i][1] = scanner.nextInt();
        }
        System.out.println("From which point you want to start? \n Choose points from 1 to " + (matrixSize));
        int startPoint = scanner.nextInt();
        startPoint--;
        double distance = 0, shortestWay = 0;
        int move = 0;
        boolean[] visitedPoint = new boolean[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            visitedPoint[i] = false;
        }
        visitedPoint[startPoint] = true;
        double totalRoad = 0;
        System.out.println("Start point => " + (startPoint + 1));
        int newStartPoint = startPoint;
        for (int i = 0; i < matrixSize - 1; i++) {
            boolean check = true;
            for (int j = 0; j < matrixSize; j++) {
                if (visitedPoint[j] == false) {
                    distance = distaneCount(matrix[newStartPoint][0], matrix[newStartPoint][1], matrix[j][0], matrix[j][1]);
                    if (check == true) {
                        shortestWay = distance + 1;
                        check = false;
                    }
                    if ((distance < shortestWay) && (distance != 0)) {
                        shortestWay = distance;
                        move = j;
                    }
                }
            }
            totalRoad += shortestWay;
            newStartPoint = move;
            visitedPoint[newStartPoint] = true;
            System.out.println("Point visited as " + (i + 2) + " => " + (move + 1));
        }
        System.out.println("Return to  => " + (startPoint));
        double backToStartPoint = distaneCount(matrix[startPoint][0], matrix[startPoint][1], matrix[move][0], matrix[move][1]);
        travelDistance = totalRoad + backToStartPoint;
        System.out.println("Traveled distance : " + travelDistance);

    }
}
