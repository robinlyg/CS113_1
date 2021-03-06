import java.util.ArrayList;
import java.util.Objects;

public class Term  {
    private int mCoefficient;
    private int mExponent;
    private char mBase;
    private boolean mHasMatch;



    public Term(int coefficient, int exponent, char base)
    {
        mCoefficient = coefficient;
        mExponent = exponent;
        mBase = base;
        mHasMatch = false;

    }
    public Term(int coefficient)
    {
        mCoefficient = coefficient;
        mHasMatch = false;
        //mExponent = 1;

    }
    public Term (char base)
    {
        mCoefficient = 1;
        mBase = base;
        mHasMatch = false;

        //mExponent = 1;
    }
    public Term (int coefficient, int exponent)
    {
        mCoefficient = coefficient;
        mExponent = exponent;
        mHasMatch = false;

    }

    public Term(int coefficient, char base)
    {
        mCoefficient = coefficient;
        mBase = base;
        mHasMatch = false;
        mExponent = 1;
    }

    public Term()
    {
        mCoefficient = 0;
        mExponent =0;
        mHasMatch = false;
    }

    public boolean getHasBase() {return mHasMatch;  }

    public void setCo(int newCo)
    {
        mCoefficient = newCo;
    }

    public void setExponent (int newEx) { mExponent = newEx; }

    public int getCo()
    {
        return mCoefficient;
    }

    public int getEx()
    {
        return mExponent;
    }

    public char getBase()
    {
        return mBase;
    }

    public void setMatch(boolean newMatch){mHasMatch = newMatch; }

    public String toString()
    {
       StringBuilder poly = new StringBuilder();
       //if it has a co and ex - as long has ex is not 0 or 1
       if(this.mBase == 'x')
       {

           if(this.mCoefficient ==0)
           {
               return "";
           }
           else if (this.mCoefficient > 1 || this.mCoefficient < 0)
           {

               poly.append(mCoefficient);
           }

           if(this.mExponent == 0 || this.mExponent == 1) {
           poly.append("x");
           return poly.toString();
            }

           else {
               poly.append("x^").append(mExponent);
               return poly.toString();
           }
            //if has co and ex but ex == 1 or ==0 we dont want to print the ex

       }

       poly.append(mCoefficient);
       return poly.toString();
    }

//equals method



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return mExponent == term.mExponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCoefficient, mExponent, mBase);
    }
}
