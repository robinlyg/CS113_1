import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //ArrayList<String> polyList = new ArrayList<>();
        ArrayList<Term> termList = new ArrayList<>();
        ArrayList<Term> termListOne = new ArrayList<>();
        String input;
        int count = 0;
        //Poly polyOne = new Poly();
        //Poly myPoly = new Poly();

        //ask user for polynomial and store use input as a string

        System.out.println("Please enter polynomial");
        input = keyboard.nextLine();
        termListOne = checkPoly(input);
        Poly polyOne = new Poly(termListOne);

        System.out.println("Please enter polynomial");
        input = keyboard.nextLine();
        termList = checkPoly(input);
        Poly myPoly = new Poly(termList);


/*
          //replace - with +- so we can use + has our delimiter and retain our neg
            String newPoly = input.replace(" - ", "+-");
            //remove all spaces to keep from getting NumberFormatException
            String noSpace = newPoly.replace(" ", "");

            //remove x, now our only 2 non-digit characters are the + and ^

        //create scanner object, so we can utilize useDelimiter()
        //the + char is our delim
            Scanner delim = new Scanner(noSpace);
            delim.useDelimiter("\\+");
            //loop through the string based on delim which separates each term
            //then break each term apart into co and ex
            // System.out.println("no space = " + noSpace);
            while (delim.hasNext()) {
                String term = delim.next();

                if (!hasDigit(term)) {
                    System.out.println("Error, one or more Terms was non-numeric");
                    //System.exit(0);
                    continue;
                }

                //if the term contains ^ that implies theres a co and ex
                if (term.contains("^") && term.contains("x")) {                 */

    /* int indexOfC = term.indexOf("x");
                if(indexOfC == 0)
                {
                    co = 1;
                }
                else
                {
                    co = Integer.parseInt(term.substring(0, indexOfC));
                }
                ex = Integer.parseInt(term.substring(indexOfC+2));
                // if ex = 0 then co == 1
                if(ex == 0)
                {
                    co = Integer.parseInt(term.substring(0, indexOfC));
                    if(co > 0) {
                        t = new Term(1);
                    }
                    else{
                        t = new Term(-1);
                    }
                    termList.add(t);
                    //want to skip the rest in this outer if statement
                    continue;
                }
                //System.out.println("Ex = " + ex);
                t = new Term(co, ex, 'x');
                termList.add(t);
               //
*/

    /*                termList.add(both(term));
                }
                //has a base but not an exponent
                else if (term.contains("x") && !term.contains("^")) {

                    termList.add(onlyX(term));
                }
                //if term conains a ^ but no x we can solve and store as co
                else if (!term.contains("x") && term.contains("^")) {
                    termList.add(onlyCarrot(term));
                }

                //if no ^ then no ex to parse
                else {
                    termList.add(noChars(term));
                }
            }//end while hasNext()              */


        System.out.println("\nPrint Poly ");
        System.out.println("PolyOne: " + termListOne + "\ntermList " + termList);

        System.out.println("add polys\n");
        Poly polySum = addPolys(termListOne, termList);
        System.out.println("Sum = " + polySum);

    }//method

    public static Term both(String term) {
        int co;
        int ex;

        int indexOfC = term.indexOf("x");
        int neg = term.indexOf("-");
        if (indexOfC == 0) {
            co = 1;
        } else if (indexOfC == 1 && neg == 0) {
            co = -1;
        } else {

            co = Integer.parseInt(term.substring(0, indexOfC));
        }
        ex = Integer.parseInt(term.substring(indexOfC + 2));
        // if ex = 0 then co == 1
        if (ex == 0) {
            if (indexOfC == 0) {
                co = 1;
            } else {
                co = Integer.parseInt(term.substring(0, indexOfC));
            }
            if (co > 0) {
                //return new Term(1);
                co = 1;
            } else {
                //return new Term(-1);
                co = -1;
            }

            return new Term(co);
        }

        //System.out.println("Ex = " + ex);
        return new Term(co, ex, 'x');
    }

    //contains an x but no carrot
    public static Term onlyX(String term) {
        if (term.length() == 1) {
            return new Term('x');
        } else {
            int indexOfC = term.indexOf("x");
            int co = Integer.parseInt(term.substring(0, indexOfC));
            return new Term(co, 'x');
        }
    }

    //contains a ^ but no x
    public static Term onlyCarrot(String term) {
        int indexOfC = term.indexOf("^");
        int co = Integer.parseInt(term.substring(0, indexOfC));
        int ex = Integer.parseInt(term.substring(indexOfC + 1));
        double sum = Math.pow(co, ex);
        int value = (int) sum;
        return new Term(value);
    }

    //no carrot or x
    public static Term noChars(String term) {
        int co = Integer.parseInt(term);
        if (co == 0) return new Term();

        return new Term(co);
        // termList.add(t);
    }

    //has digit
    public static boolean hasDigit(String t) {
        String regex = ".*[0-9].*";
        boolean matches = t.matches(regex);
        return matches;

    }

    public static ArrayList<Term> checkPoly(String input) {
        ArrayList<Term> termList = new ArrayList<>();

        //replace - with +- so we can use + has our delimiter and retain our neg
        String newPoly = input.replace(" - ", "+-");
        //remove all spaces to keep from getting NumberFormatException
        String noSpace = newPoly.replace(" ", "");

        //remove x, now our only 2 non-digit characters are the + and ^

        /*create scanner object, so we can utilize useDelimiter()
        the + char is our delim*/
        Scanner delim = new Scanner(noSpace);
        delim.useDelimiter("\\+");
        //loop through the string based on delim which separates each term
        //then break each term apart into co and ex
        // System.out.println("no space = " + noSpace);
        while (delim.hasNext()) {
            String term = delim.next();

            if (!hasDigit(term)) {
                System.out.println("Error, one or more Terms was non-numeric");
                //System.exit(0);
                continue;
            }

            //if the term contains ^ that implies theres a co and ex
            if (term.contains("^") && term.contains("x")) {
                // System.out.println("IN IF STATEMENT");
               /* int indexOfC = term.indexOf("x");
                if(indexOfC == 0)
                {
                    co = 1;
                }
                else
                {
                    co = Integer.parseInt(term.substring(0, indexOfC));
                }
                ex = Integer.parseInt(term.substring(indexOfC+2));
                // if ex = 0 then co == 1
                if(ex == 0)
                {
                    co = Integer.parseInt(term.substring(0, indexOfC));
                    if(co > 0) {
                        t = new Term(1);
                    }
                    else{
                        t = new Term(-1);
                    }
                    termList.add(t);
                    //want to skip the rest in this outer if statement
                    continue;
                }
                //System.out.println("Ex = " + ex);
                t = new Term(co, ex, 'x');
                termList.add(t);
               //
*/

                termList.add(both(term));
            }
            //has a base but not an exponent
            else if (term.contains("x") && !term.contains("^")) {

                termList.add(onlyX(term));
            }
            //if term conains a ^ but no x we can solve and store as co
            else if (!term.contains("x") && term.contains("^")) {
                termList.add(onlyCarrot(term));
            }

            //if no ^ then no ex to parse
            else {
                termList.add(noChars(term));
            }
        }//end while hasNext()

        return termList;
    }

   /* public static boolean match(Term t, Term s)
    {
        System.out.println("t.getCo() = " + t.getEx() + "   s.getCo() = " + s.getEx());
        return t.getEx() == s.getEx();
    }
*/

   public static Poly addPolys(ArrayList<Term> arrayListOne, ArrayList<Term> arrayListTwo) {
        ArrayList<Term> termArrayList = new ArrayList<>();
        int newCo;


       for (int i =0; i < arrayListOne.size(); i++) {
           //System.out.println("extract index from ArrayOne index =: " + i + " " + arrayListOne.get(i));

            for (int j = i; j<arrayListTwo.size(); j++) {
                System.out.println("compare = index i: " +  i + " " + arrayListOne.get(i)  + " and index j " + j + " " + arrayListTwo.get(j));

                if (arrayListOne.get(i).getEx() == arrayListTwo.get(j).getEx()) {
                    System.out.println("adding together " + arrayListOne.get(i) +  arrayListTwo.get(j));
                    newCo = arrayListOne.get(i).getCo() + arrayListTwo.get(j).getCo();
                    termArrayList.add(new Term(newCo, arrayListOne.get(i).getEx(),arrayListTwo.get(j).getBase()));
                    System.out.println("what was added to the empty array list " + new Term(newCo, arrayListOne.get(i).getEx(),arrayListTwo.get(j).getBase()));
                    //how to continue to outter loop???????
                }
                else{
                    if(!termArrayList.contains(arrayListOne.get(i))) {
                        termArrayList.add(arrayListOne.get(i));
                        System.out.println("Added in ELSE statement from arrayListOne :" + arrayListOne.get(i));
                    }
                    if(j == 0)
                    {
                        termArrayList.add(arrayListTwo.get(j));
                        System.out.println("Added in ELSE/if statement from arrayListTwo :" + arrayListTwo.get(j));
                       // indexOfArrayTwo +=1;

                    }

                }

            }

           //indexOfArrayOne +=1;
        }


        return new Poly(termArrayList);
    }




}//class


