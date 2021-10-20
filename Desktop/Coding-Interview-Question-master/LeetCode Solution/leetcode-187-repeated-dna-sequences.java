/** HashMap Solution **/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() > 1) {
                list.add(item.getKey());
            }
        }
        
        return list;
        
    }
}
Time Complexity: O(n)
Space Complexity: O(n)

/** HashSet Solution **/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (set.contains(substring)) {
                list.add(substring);
            } else {
                set.add(substring);
            }
        }
        return new ArrayList(list);
    }
}

Time Complexity: O(n)
Space Complexity: O(n)
