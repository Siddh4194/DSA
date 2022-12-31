//union of two arrays not optimized
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i1:arr1)
        {
            if(al.contains(i1))
            {
                continue;
            }
           al.add(i1); 
        }
        for(int i:arr2)
        {
            if(al.contains(i))
            {
                continue;
            }
            al.add(i);
        }
        Collections.sort(al);
        return al;
    }
}
//union of two arrays optimized
public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
           TreeSet <Integer> s=new TreeSet<>();
  ArrayList < Integer > Union=new ArrayList<>();
  for (int i = 0; i < n; i++)
    s.add(arr1[i]);
  for (int i = 0; i < m; i++)
    s.add(arr2[i]);
  for (int it: s)
    Union.add(it);
  return Union;
    }
   
