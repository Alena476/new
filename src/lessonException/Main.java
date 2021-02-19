package lessonException;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException{
        String[][] array = new String[4][4];
        array[0] = new String[]{"1", "1", "1", "1"};
        array[1] = new String[]{"2", "2", "6", "2"};
        array[2] = new String[]{"3", "3", "3", "3"};
        array[3] = new String[]{"4", "4", "4", "5"};
        addArrayAndSum(array);
    }

    public static void addArrayAndSum(String[][] array)  throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j= 0; j < array[i].length; j++) {

                if(array.length != 4 || array[i].length != 4) {
                    throw new MyArraySizeException("Неправильный размер массива.");
                }

                try{
                    Integer.parseInt(array[i][j]);
                } catch(Exception e) {
                    System.err.println("В ячейке с номером: " + i + " " + j + " находится не число!");
                    throw new MyArrayDataException("Некоторые ячейки могут содержать буквы или символы"
                            + "Номер элемента: ");
                }

                sum = sum + Integer.parseInt(array[i][j]);
            }
        }
        System.out.println("Сумма равна: " + sum);
        System.out.println("Массив добавили");
    }

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }
        static class MyArrayDataException extends Exception {
            public MyArrayDataException(String message) {
                super(message);
            }
    }
}
