import java.util.ArrayList;

public class Poly extends Term {
    private ArrayList<Term> mTerm;

   public Poly(ArrayList<Term> term )
   {
      mTerm = term;

    }

    public Poly()
    {     mTerm = new ArrayList<>();   }


//adding polys - if exponent are == we can add the coefficents which creates a new term
    //adding polys, by comparing the two, we do not want to manipulate either existing poly
    //but return a new poly that contains the added elements and unmatched elements
    //if we work from one
  /* public  add(ArrayList<Term> p)
    {
        Poly newPoly = new Poly();
        //ArrayList<Term> termArrayList = new ArrayList<>();
        int newCo;
        //need to loop thru poly's to see
        for(int i = 0; i < )


    }*/




    @Override
    public String toString()
    {
        StringBuilder poly = new StringBuilder();
      /* for (Term t: mTerm) {
           poly.append(t.toString());
        }*/
        for (int i = 0; i < mTerm.size()-1; i++) {

            poly.append(mTerm.get(i)).append(" + ");
        }
            poly.append(mTerm.get(mTerm.size()-1));

        return poly.toString();
    }
}
