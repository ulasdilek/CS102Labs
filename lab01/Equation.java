package lab01;

/**
 * Equation class has three variables that can represent a linear equation in its general form:
 * a = bx + c
 * The class makes sure to always keep the coefficient of x non-negative.
 * Call {@code add(Equation eq2)} to add the current equation with another one.
 * Call {@code substract(Equation eq2)} to substract another equation from the current one.
 * Call {@code reduceEquation()} to reduce the current equation to the smallest positive integers.
 * @author Ulas Dilek
 * @version v1.0
 */

public class Equation{

    private int a, b, c;

    /**
     * Constructs an Equation instance with the given coefficients in the form of a = bx + c 
     * @param a The constant that corresponds to a.
     * @param b The coefficient of x. Will always be non-negative.
     * @param c The constant that corresponds to c.
     */
    public Equation (int a, int b, int c) {
        setA(a);
        setC(c);
        setB(b);
    }
    
    /**
     * Constructs the copy of another {@code Equation} instance.
     * @param eq The {@code Equation} instance to be copied.
     */
    public Equation (Equation eq) {
        setA(eq.a);
        setB(eq.b);
        setC(eq.c);
    }

    /**
     * Setter for {@code a}.
     * @param a Given value for a.
     */
    private void setA(int a) {
        this.a = a;
    }

    /**
     * Setter for {@code b}. The setter will make sure to always keep b non-negative.
     * When {@code b} is given negative, the equation is multiplied with -1.
     * @param b Given value for b.
     */
    private void setB(int b) {
        if (b < 0) {
            this.b = -b;
            setA(-a);
            setC(-c);
        }
        else {
            this.b = b;
        }
    }

    /**
     * Setter for {@code c}.
     * @param c Given value for c.
     */
    private void setC(int c) {
        this.c = c;
    }

    /**
     * Adds the current {@code Equation} instance with another one and returns the result.
     * Reduces the result before returning.
     * As an example:
     *  a1       =  b1x       +  c1
     *  a2       =  b2x       +  c2
     *  + + + + + + + + + + + + + + + + +
     * (a1 + a2) = (b1 + b2)x + (c1 + c2)
     * @param eq2 Given equation instance.
     * @return The sum of two equations.
     */
    public Equation add(Equation eq2) {
        Equation result = new Equation(a + eq2.a, b + eq2.b, c + eq2.c);
        result.reduceEquation();
        return result;
    }

    /**
     * Substracts another {@code Equation} instance with the current one and returns the result.
     * Reduces the result before returning.
     * As an example:
     *  a1       =  b1x       +  c1
     *  a2       =  b2x       +  c2
     *  - - - - - - - - - - - - - - - - -
     * (a1 - a2) = (b1 - b2)x + (c1 - c2)
     * @param eq2 Given equation instance.
     * @return The result of the substraction.
     */
    public Equation substract(Equation eq2) {
        Equation result = new Equation(a - eq2.a, b - eq2.b, c - eq2.c);
        result.reduceEquation();
        return result;
    }

    /**
     * Reduces the current {@code Equation} instance to express it with the least positive integers.
     */
    public void reduceEquation() {
        int gcd = gcd(Math.abs(a), Math.abs(b), Math.abs(c));
        setA(a / gcd);
        setC(c / gcd);
        setB(b / gcd);
    }

    /**
     * Finds the Greatest Common Divisor of three integers.
     * 
     * @throws DivisonByZeroException The mathematical definition of GCD uses only non-negative integers.
     *                                This implementation requires non-negative input to function properly
     * @param x A non-negative integer.
     * @param y A non-negative integer.
     * @param z A non-negative integer.
     * @return The Greatest Common Divisor of x, y and z.
     */
    private int gcd(int x, int y, int z) {
        
        return gcd(gcd(x, y), z);
    }

    /**
     * Uses Euclid's method to find the Greatest Common Divisor of three integers.
     * 
     * @throws DivisonByZeroException The mathematical definition of GCD uses only non-negative integers.
     *                                This implementation requires non-negative input to function properly
     * @param x A non-negative integer.
     * @param y A non-negative integer.
     * @return The Greatest Common Divisor of x and y.
     */
    private int gcd(int x, int y) {
        // order is important to avoid complication while taking remainder
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        // base case
        if ( y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

    /**
     * Checks if the current equation is the same as another one. If the reduced versions of each equation
     * are the same, then the equations are the same as well.
     * @param obj The Object to be used in the comparison.
     * @return Wheter two equations are same or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Equation) {
            Equation other = (Equation) obj;
            Equation e1 = new Equation(this);
            Equation e2 = new Equation(other);
            e1.reduceEquation();
            e2.reduceEquation();
            return e1.a == e2.a && e1.b == e2.b && e1.c == e2.c;
        }
        return false;
    }

    /**
     * Represents the equation in the general linear equation format.
     * For a nicer representation:
     *      bx is omitted if b = 0
     *      c is omitted if c = 0
     *      b is omitted if b = 1
     * @return "a = bx + c"
     */
    @Override
    public String toString() {
        if (b == 0) {
            return a + " = " + c;
        }
        if (c == 0) {
            if (b == 1) {
                return a + " = x";
            } 
            return a + " = " + b + "x";
        }
        String sign = c < 0 ? " - " : " + " ;
        if (b == 1) {
            return a + " = x" + sign + Math.abs(c);
        } 
        return a + " = " + b + "x" + sign + Math.abs(c);
    }
    
}