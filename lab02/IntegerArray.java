package lab02;

public class IntegerArray implements Comparable<IntegerArray> {

    private int[] digits;
    
    public IntegerArray(String number) {
        int startIndex = 0;
        for (int i = 0; i < number.length(); i++) {
            startIndex = i;
            if (number.charAt(i) != '0') {
                i = number.length(); // pseudobreak
            }
        }
        digits = new int[number.length() - startIndex];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(number.charAt(i + startIndex));
        }
    }

    private IntegerArray(int[] digits) {
        int startIndex = 0;
        for (int i = 0; i < digits.length; i++) {
            startIndex = i;
            if (digits[i] != 0) {
                i = digits.length; // pseudobreak
            }
        }
        this.digits = new int[digits.length - startIndex];
        for (int i = 0; i < this.digits.length; i++) {
            this.digits[i] = digits[i + startIndex];
        }
    }

    public int numberOfDigits() {
        return digits.length;
    }

    public int MID() {
        return getDigit(0);
    }

    public int LID() {
        return getDigit(numberOfDigits() - 1);
    }

    public int getDigit(int index) {
        if (index >= numberOfDigits() || index < 0) {
            return 0;
        }
        return digits[index];
    }

    public IntegerArray add(IntegerArray other) {
        int[] result = new int[numberOfDigits() + 1];
        for (int i = 0; i < numberOfDigits(); i++) {
            result[i + 1] = getDigit(i);
        }
        int dif = numberOfDigits() - other.numberOfDigits();
        for (int i = numberOfDigits() - 1; i >= 0; i--) {
            result[i + 1] += other.getDigit(i - dif);
            validateDigit(result, i + 1);
        }
        return new IntegerArray(result);
    }

    // substraction is just addition in disguise :)
    public IntegerArray subtract(IntegerArray other) {
        // add() for substraction assumes that the other is not greater than this
        // so this if block is a workaround for that
        if (compareTo(other) < 0) {
            return other.add(this.changeSign()).changeSign();
        }
        return add(other.changeSign());
    }

    private IntegerArray changeSign() {
        int[] result = new int[numberOfDigits()];
        for (int i = 0; i < result.length; i++) {
            result[i] = getDigit(i) * (-1);
        }
        return new IntegerArray(result);
    }

    // ensures that all digits are in the set Z10
    private void validateDigit(int[] array, int index) {
        if (array[index] >= 10) {
            array[index - 1]++;
            array[index] -= 10;
        }
        if (array[index] < 0) {
            array[index - 1]--;
            array[index] += 10;
        }
    }

    @Override
    public int compareTo(IntegerArray other) {
        if (numberOfDigits() > other.numberOfDigits()) {
            return 1;
        }
        if (numberOfDigits() < other.numberOfDigits()) {
            return -1;
        }
        for (int i = 0; i < numberOfDigits(); i++) {
            if (getDigit(i) > other.getDigit(i)) {
                return 1;
            }
            if (getDigit(i) < other.getDigit(i)) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntegerArray) {
            IntegerArray other = (IntegerArray) obj;
            if (compareTo(other) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i : digits) {
            result += i;
        }
        return result;
    }
    
}
