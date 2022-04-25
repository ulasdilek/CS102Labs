package lab06.generators;

public class DecreasingArrayGenerator implements ArrayGenerator{
    
    @Override
    public Integer[] generate(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = n - i;
        }
        return array;
    }
    
}
