package com.noe;

import java.util.HashSet;
import java.util.Set;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
public class test {
    public static void main(String[] args) {
        int[][] ob = new int[][]{{4,2}};
        System.out.println(robot("URR", ob, 3, 2 ));
    }
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<String> sets = new HashSet<>();
        char[] chars = command.toCharArray();
        for(int i = 0; i < obstacles.length; i++) {
            String s = obstacles[i][0]+"#"+obstacles[i][1];
            sets.add(s);
        }
        int curx = 0, cury = 0;
        int index = 0;
        while(curx <= x && cury <= y) {
            if (curx == x && cury == y) {
                return true;
            }

            String loc = curx+"#"+cury;
            if (sets.contains(loc)) return false;

            if (index == chars.length) index = 0;

            if (chars[index] == 'U') {
                cury++;
            } else {
                curx++;
            }
            index++;
        }
        return false;

    }
}
