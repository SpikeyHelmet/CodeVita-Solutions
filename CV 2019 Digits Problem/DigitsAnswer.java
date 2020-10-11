//Java Solution for Digits , not very optimal but it works :)

import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N];
		String[] bitscore = new String[N];
		ArrayList<String> oddbit = new ArrayList<String>();
	    ArrayList<String> evenbit = new ArrayList<String>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		//insert map values
	    for(int i=0;i<10;i++)
	    {
	       map.put(i,0);
	    }
	    //get variables
	    int noinp = 0;
		for(int i=0;i<N;i++)
		{
		   int check1=s.nextInt();
		   if(check1<1000 && check1>99)
		   {
		       arr[i]=check1;
		   }
		   else{
		       noinp++;
		   }
		}
	    if(N<=500 && N>1){
		for(int i=0;i<N-noinp;i++)
		{
		 ArrayList<Integer> test1 = new ArrayList<Integer>();
		 int temp = arr[i];

		 test1.add(temp%10);
         test1.add((temp/10)%10);
         test1.add(temp/100);

		 int tempbit = (Collections.min(test1)*7) + (Collections.max(test1)*11);

		 if(tempbit>99)
		 {
		     String str = Integer.toString(tempbit);
		     
		     bitscore[i] = str.substring(1);
		 }
		 else
		 {
		     bitscore[i] = String.valueOf(tempbit);
		 }
		// System.out.println(bitscore[i]);
		}

		for(int i=0;i<N-noinp;i++)
		{
		if(i%2==0)
        {
            evenbit.add(bitscore[i]);
        }
        else
        {
            oddbit.add(bitscore[i]);
        }
	  }
	  
	 
	 for(int i=0;i<((N-noinp)/2)-1;i++)
	 {
	  for(int j=i+1;j<((N-noinp)/2);j++){
	     char x = oddbit.get(i).charAt(0);
	     char y = oddbit.get(j).charAt(0);
	     if(x==y)
	     {
	         int local = map.get(Character.getNumericValue(x));
	         if(local<2)
	         {
	         map.replace(Integer.parseInt(String.valueOf(x)),local+1);
	         break;
	         }
	     }
	  }
	 }
	 for(int i=0;i<((N-noinp)/2)-1;i++)
	 {
	  for(int j=i+1;j<((N-noinp)/2);j++){
	     char x = evenbit.get(i).charAt(0);
	     char y = evenbit.get(j).charAt(0);
	     if(x==y)
	     {
	         int local = map.get(Character.getNumericValue(x));
	         if(local<2)
	         {
	         map.replace(Integer.parseInt(String.valueOf(x)),local+1);
	         break;
	         }
	      }
	    }
	 }
	 int pairs=0;
	 for(int z=0;z<10;z++)
	 {
	     pairs+=map.get(z);
	 }
	 System.out.print(pairs);
    }
  }
}
