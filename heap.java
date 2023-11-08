// frequency of window numbers
class Solution
{
    ArrayList<Integer> countDistinct(int nums[], int n, int k)
    {
        // code here 
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i = 0; i < n - k + 1; i++){
        //     Set<Integer> de = new HashSet<>();
        //     for(int j = i; j < i + k; j++){
        //         de.add(A[j]);
        //     }
        //     ans.add(de.size());
        // }
        // return ans;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int distinctCount = 0;

        for (int i = 0; i < k; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            if (frequencyMap.get(nums[i]) == 1) {
                distinctCount++;
            }
        }
        result.add(distinctCount);

        for (int i = k; i < nums.length; i++) {
            frequencyMap.put(nums[i - k], frequencyMap.get(nums[i - k]) - 1);
            if (frequencyMap.get(nums[i - k]) == 0) {
                distinctCount--;
            }

            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            if (frequencyMap.get(nums[i]) == 1) {
                distinctCount++;
            }

            result.add(distinctCount);
        }

        return result;
    }
}

