package lab02;

import java.util.ArrayList;

public class IntegerArrayList {
    
    private ArrayList<IntegerArray> numbers;

    public IntegerArrayList(ArrayList<String> numStrings) {
        numbers = new ArrayList<>();
        for (String number : numStrings) {
            numbers.add(new IntegerArray(number));
        }
    }

    public int getSize() {
        return numbers.size();
    }

    public IntegerArray getIntegerArray(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr)  throws IndexOutOfBoundsException {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        numbers.set(index, intArr);
    }

    public void addIntegerArray(String number){
        numbers.add(new IntegerArray(number));
    }

    public void removeIntegerArray(int index){
        numbers.remove(index);
    }

    public void removeIntegerArray(IntegerArray intArr){
        numbers.remove(intArr);
    }

    public IntegerArray min(int start, int end) {
        IntegerArray min = numbers.get(start);
        for (int i = start + 1; i < end; i++) {
            if (numbers.get(i).compareTo(min) < 0) {
                min = numbers.get(i);
            }
        }
        return min;
    }

}
