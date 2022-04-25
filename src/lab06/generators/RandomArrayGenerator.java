package lab06.generators;

public class RandomArrayGenerator implements ArrayGenerator {
    
    @Override
    public Integer[] generate(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * n) + 1;
        }
        return array;
    }
    
}
