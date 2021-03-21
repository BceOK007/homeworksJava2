package Java2;

public class Main {

    static final int SIZE = 4;

    public static void main(String[] args) {

        String[][] stringArray = {{"46", "53", "54", "4"},
                                {"5", "4", "4", "3"},
                                {"45", "73", "34", "4"},
                                {"0", "23", "-57", "4"}};

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                System.out.print(stringArray[i][j] + "\t\t\t");
            }
            System.out.println();
        }

        try {
            System.out.println("Сумма всех элементов массива = " + sumElementsArray(stringArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumElementsArray (String[][] arr) throws MyArrayDataException, MyArraySizeException{

        if (arr.length != SIZE) {
            throw new MyArraySizeException(String.format("Ожидаемое кол-во строк в массиве %d, а фактически %d", SIZE, arr.length));
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new MyArraySizeException(String.format("Ожидаемое кол-во элементов в каждой строке %d, а в строке %d их %d", SIZE, i, arr[i].length));
            }
        }

        int sumElements = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sumElements += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Некорректные данные '%s' в ячейке [%d][%d]", arr[i][j], i, j));
                }
            }
        }

        return sumElements;
    }

}
