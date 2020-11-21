package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MaxTwo {
    public static void main(String[] args) {
        int[] arr = {6,6,4,6,3,2,7,4};
        System.out.println(sum(arr, 3, 2));

    }

    private static int sum(int[] A, int K, int L) {
        TreeMap<Integer, List<String>> treeMapK = new TreeMap<>();
        TreeMap<Integer, List<String>> treeMapL = new TreeMap<>();
        int len = A.length;
        int j = 0;
        int tempK = 0;
        String sK = "", sL = "";
        int tempL = 0;
        int temp = 0;
        String s = "";
        int maxInd, minInd;
        if (K + L > A.length) {
            return 0;
        }
        for (int i = 0; i < Math.min(K, L); i++) {
            temp = temp + A[i];
            s = s + i;
        }
        if (K < L) {
            tempK = temp;
            sK = s;
            List<String> l = new ArrayList<>();
            l.add(sK);
            treeMapK.put(tempK, l);
            maxInd = L;
            minInd = K;
        } else if (K > L) {
            tempL = temp;
            sL = s;
            List<String> l = new ArrayList<>();
            l.add(sL);
            treeMapL.put(tempL, l);
            maxInd = K;
            minInd = L;
        } else {
            tempK = temp;
            sK = s;
            List<String> l = new ArrayList<>();
            l.add(sK);
            treeMapK.put(tempK, l);
            tempL = temp;
            sL = s;
            l = new ArrayList<>();
            l.add(sL);
            treeMapL.put(tempL, l);
            maxInd = K;
            minInd = L;
        }
        int indSK = 0, indEK = K - 1, indSL = 0, indEL = L - 1;
        for (int i = minInd; i < maxInd; i++) {
            temp += A[i];
            s += i;
        }
        if (treeMapK.isEmpty()) {
            tempK = temp;
            sK = s;
            List<String> l = new ArrayList<>();
            l.add(sK);
            treeMapK.put(tempK, l);
        }
        if (treeMapL.isEmpty()) {
            tempL = temp;
            sL = s;
            List<String> l = new ArrayList<>();
            l.add(sL);
            treeMapL.put(tempL, l);
        }
        while (indEK < len - 1 && indEL < len - 1) {
            tempK = tempK - A[indSK] + A[indEK + 1];
            indSK++;
            indEK++;
            sK = sK.substring(1) + indEK;
            tempL = tempL - A[indSL] + A[indEL + 1];
            indSL++;
            indEL++;
            sL = sL.substring(1) + indEL;
            if (treeMapK.get(tempK) != null) {
                List<String> l = treeMapK.get(tempK);
                l.add(sK);
                treeMapK.put(tempK, l);

            } else {
                List<String> l = new ArrayList<>();
                l.add(sK);
                treeMapK.put(tempK, l);

            }

            if (treeMapL.get(tempL) != null) {
                List<String> l = treeMapL.get(tempL);
                l.add(sL);
                treeMapL.put(tempL, l);

            } else {
                List<String> l = new ArrayList<>();
                l.add(sL);
                treeMapL.put(tempL, l);

            }
        }

        if (indEK < indEL) {
            while (indEK < len) {
                tempK = tempK - A[indSK] + A[indEK + 1];
                indSK++;
                indEK++;
                sK = sK.substring(1) + indEK;
                if (treeMapK.get(tempK) != null) {
                    List<String> l = treeMapK.get(tempK);
                    l.add(sK);
                    treeMapK.put(tempK, l);

                } else {
                    List<String> l = new ArrayList<>();
                    l.add(sK);
                    treeMapK.put(tempK, l);

                }
            }
        } else if (indEL < indEK) {
            while (indEL < len - 1) {
                tempL = tempL - A[indSL] + A[indEL + 1];
                indSL++;
                indEL++;
                sL = sL.substring(1) + indEL;
                if (treeMapL.get(tempL) != null) {
                    List<String> l = treeMapL.get(tempL);
                    l.add(sL);
                    treeMapL.put(tempL, l);

                } else {
                    List<String> l = new ArrayList<>();
                    l.add(sL) ;
                    treeMapL.put(tempL, l);

                }
            }
        }
        int maxFirst;
        int maxSecond;
        if (K < L) {
            maxFirst = treeMapK.lastKey();
            List<String> maxFirstStr = treeMapL.get(maxFirst);
            maxSecond = treeMapL.lastKey();
            List<String> maxSecondStr = treeMapK.get(maxSecond);
            boolean found = false;
            boolean finalans = false;
            while (!finalans) {
                for (String s1 : maxFirstStr) {
                    for (String s2 : maxSecondStr) {
                        if (s1.contains(s2)) {
                            found = true;

                        }
                        else{
                            break;
                        }

                    }
                    if (!found) {
                        break;
                    }
                }
                if (!found) {
                    finalans = true;
                }
                else {
                    treeMapK.remove(maxSecond);
                    maxSecond = treeMapK.lastKey();
                    maxSecondStr = treeMapK.get(maxSecond);
                }
            }

        } else if (L < K) {
            maxFirst = treeMapK.lastKey();
            List<String> maxFirstStr = treeMapK.get(maxFirst);
            maxSecond = treeMapL.lastKey();
            List<String> maxSecondStr = treeMapL.get(maxSecond);
            boolean found = false;
            boolean finalans = false;
            while (!finalans) {
                for (String s1 : maxFirstStr) {
                    for (String s2 : maxSecondStr) {
                        if (s1.contains(s2)) {
                            found = true;

                        }
                        else{
                            break;
                        }

                    }
                    if (!found) {
                        break;
                    }
                }
                if (!found) {
                    finalans = true;
                }
               else {
                    treeMapL.remove(maxSecond);
                    maxSecond = treeMapL.lastKey();
                    maxSecondStr = treeMapL.get(maxSecond);
                }
            }


        } else {
            maxFirst = treeMapK.lastKey();
            List<String> maxFirstStr = treeMapK.get(maxFirst);
            maxSecond = treeMapL.lastKey();
            List<String> maxSecondStr = treeMapL.get(maxSecond);
            boolean found = false;
            boolean finalans = false;
            while (!finalans) {
                for (String s1 : maxFirstStr) {
                    for (String s2 : maxSecondStr) {
                        if (s1.contains(s2)) {
                            found = true;

                        }
                        else{
                            break;
                        }

                    }
                    if (!found) {
                        break;
                    }
                }
                if (!found) {
                    finalans = true;
                }
                else {
                    treeMapL.remove(maxSecond);
                    maxSecond = treeMapL.lastKey();
                    maxSecondStr = treeMapL.get(maxSecond);
                }
            }

        }
        return maxFirst + maxSecond;

    }
}
