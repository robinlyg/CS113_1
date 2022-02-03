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
 /*  public Poly add(ArrayList<Term> p)
    {
        Poly newPoly = new Poly();
        ArrayList<Term> termArrayList = new ArrayList<>();
        int newCo;
        //need to loop thru poly's to see
        for(Term t : p)
        {

            for(Term t2 : this.mTerm)
            {// if terms have == ex if so we add
                if(t2 == null)
                {
                    break;
                }
                if(t2.getEx() == t.getEx())
                {
                    newCo = t2.getCo() + t.getCo();
                    termArrayList.add(new Term(newCo,t.getEx(), 'x'));

                }
            }
        }

        return newPoly.add(termArrayList);

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
