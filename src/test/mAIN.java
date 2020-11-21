package test;

import java.util.*;

public class mAIN {
    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        Map<String, List<String>> m = new HashMap<>();
        //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
        for (PairString p : itemAssociation) {
            if (!m.containsKey(p.first)) {
                m.put(p.first, new ArrayList<>());
            }
            m.get(p.first).add(p.second);
            if (!m.containsKey(p.second)) {
                m.put(p.second, new ArrayList<>());
            }
        }
        //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
        Map<Integer, List<List<String>>> sm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (String key : m.keySet()) {
            Queue<String> q = new LinkedList<>();
            TreeSet<String> t = new TreeSet<>();
            q.offer(key);
            while (!q.isEmpty()) {
                String head = q.poll();
                t.add(head);
                List<String> temp = m.get(head);
                for (String x : temp) {
                    q.offer(x);
                }
            }
            int size = t.size();
            max = Math.max(max, size);
            if (!sm.containsKey(size)) {
                sm.put(size, new ArrayList<>());
            }
            sm.get(size).add(new ArrayList<>(t));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        List<List<String>> maxlist = sm.get(max);

        Collections.sort(maxlist, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; i++) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });

        return maxlist.get(0);
    }

    public static void main(String[] args) {
        mAIN s = new mAIN();
        /**
         * Example 1
         */
        List<PairString> input = Arrays.asList(
                s.new PairString("item1", "item2"),
                s.new PairString("item3", "item4"),
                s.new PairString("item4", "item5"));
        /**
         * Testing equal sized arraylist. 1->2->3->7 4->5->6->7
         */
        List<PairString> input2 =  Arrays.asList(
                s.new PairString("item1","item2"),
                s.new PairString("item2","item3"),
                s.new PairString("item4","item5"),
                s.new PairString("item6","item7"),
                s.new PairString("item5","item6"),
                s.new PairString("item3","item7"));
        List<String> lst = s.largestItemAssociation(input);
        for (String sa : lst) System.out.print(" " + sa);
        System.out.println();
        List<String> lst2 = s.largestItemAssociation(input2);
        for (String sa : lst2) System.out.print(" " + sa);
        System.out.println();
        /**
         * Testing duplicates: 1->2->3->7 , 5->6
         */
        List<PairString> input3 =  Arrays.asList(
                s.new PairString("item1","item2"),
                s.new PairString("item1","item3"),
                s.new PairString("item2","item7"),
                s.new PairString("item3","item7"),
                s.new PairString("item5","item6"),
                s.new PairString("item3","item7"));

        List<String> lst3 = s.largestItemAssociation(input3);
        for (String sa : lst3) System.out.print(" " + sa);
    }

    class PairString {
        String first;
        String second ;
        PairString(String first , String second){
            this.first = first;
            this.second = second;

        }
    }
}
