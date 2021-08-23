/**
 * @author Katherine Monroy
 * 2368029
 * kmonroy@chapman.edu
 * CPSC 231-02
 * This class that creates the 3rd degree polynomial y = 0 + 3.5x + 1.5x2+ x3 and prints out the result of evaluating it for x=2.
 * @version 1.0
 */

public class Polynomial {

  // Initializes the array filled with doubles to represent the coefficient
  private double[] m_array;
  // Initializeds the int representing the degree of the polynomial
  private int m_degree;

  // Default constructor creates a degree of 0, thus creating an array with only one primitive (the primitive without any exponent)
  public Polynomial() {
    m_degree = 0;
    m_array = new double[1];
  }

  // Overloaded constructor creates an array with a specified degree, creating an empty array of that size (+ 1 for formatting)
  public Polynomial(int degree) {
      m_degree = degree;
      m_array = new double[degree + 1];
  }

  // Copy constructor creates an identical polynomial copy
  public Polynomial(Polynomial p) {
    this.m_degree = p.m_degree;
    this.m_array = p.m_array;
  }

  // Accessor to return the int degree value
  public int getDegree() {
    return m_degree;
  }

  // Accessor to return (give access to) the array of doubles that represent the polynomial
  public double getArray(int apple) {
    return m_array[apple];
  }

  // Mutator allows for the degree to be changed, in turn changing the Polynomial objects array size
  public void setDegree(int degree) {
      m_degree = degree;
      m_array = new double[degree + 1];
  }

  // getCoefficient method takes in the Polynomial array and int and returns the coefficient at the position of the int
  public double getCoefficient(int i) {
    return m_array[i];
  }

  // setCoefficient method allows for a double value to be set at a position in the Polynomial object's array, returning true if the process is successful (and false if not)
  public boolean setCoefficient(int i, double v) {
      m_array[i] = v;
      if (m_array[i] == v) {
        return true;
      }
      return false;
  }

  // toString method returns the Polynomial in it's correct form
  public String toString() {
      String ret = "y = " + m_array[0] + " + ";
      for (int i = 1; i < m_array.length; i++) {
        if (i == ((m_array.length) - 1)) {
            ret += m_array[i] + "x^" + (i);
        }
        else {
          ret += m_array[i] + "x^" + (i) + " + ";
        }
      }
      return ret;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if(!(o instanceof Polynomial)) {
      return false;
    }
    Polynomial p = (Polynomial) o;
    for (int i = 0; i < m_array.length; i++) {
        if (m_array[i] != p.m_array[i]) {
          return false;
        }
        else {
          continue;
        }
    }
    return (m_degree == p.m_degree);
  }

  // evaluate method takes in the Polynomial object and a specified value to substitute in for x, returning a total value of the Polynomial
  public double evaluate(double k) {
      double total = 0;
      for (int i = 0; i < m_array.length; i++) {
        total += (m_array[i] * (Math.pow(k,i)));
      }
      return total;
  }

  // Main method portrays the various methods working
  public static void main(String[] args) {

      // Creation of a Polynomial object of degree 3
      Polynomial p = new Polynomial(3);

      // All coefficient values are set for each position (returns true)
      p.setCoefficient(0, 0.0);
      p.setCoefficient(1, 3.5);
      p.setCoefficient(2, 1.5);
      p.setCoefficient(3, 1.0);

      // evaluate method correctly returns 21.0 as the value of the polynomial calculated
      System.out.println("y = " + p.evaluate(2));
      System.out.println(p);
  }
}
