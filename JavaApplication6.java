/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Sample Input:
3 8
3-8
do you wish to continue?(y/n):
y
10 12
3-8
10-12
do you wish to continue?(y/n):
y
10 15
3-8
10-15
do you wish to continue?(y/n):
y
0 20
0-20
do you wish to continue?(y/n):
n
*/

package javaapplication6;

import java.util.*;

/**
 *
 * @author SRIRAM
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), h = sc.nextInt();
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        low.add(l);
        high.add(h);
        String ch = "";
        while (true) {
            for (int ind = 0; ind < low.size(); ind++) {
                System.out.println(low.get(ind) + "-" + high.get(ind));
            }
            System.out.println("Do you wish to continue?(y/n):");
            ch = sc.next();
            if (!ch.equals("y")) {
                break;
            }
            l = sc.nextInt();
            h = sc.nextInt();
            boolean flag = true;
            for (int ind = 0; ind < low.size(); ind++) {
                if (low.get(ind) < l && l < high.get(ind)) {
                    if (h > high.get(ind)) {
                        high.remove(high.get(ind));
                        high.add(h);
                        flag = false;
                    }
                }
                if (low.get(ind) < h && h < high.get(ind)) {
                    if (l < low.get(ind)) {
                        low.remove(low.get(ind));
                        low.add(l);
                        flag = false;
                    }
                }
            }
            if (flag) {
                low.add(l);
                high.add(h);
            }
            Collections.sort(low);
            Collections.sort(high);
            for (int ind = 0; ind < low.size(); ind++) {
                if (ind + 1 < low.size() && high.get(ind) >= low.get(ind + 1)) {
                    System.out.println("\n test " + high.get(ind) + "-" + low.get(ind + 1) + " test");
                    low.remove(low.get(ind + 1));
                    high.remove(high.get(ind));
                    ind--;
                }
            }
        }
    }

}
