package practice.array.window;

// 文本txt寻找模式串pat的起始索引
public class Rabin_Karp {
    int rabinKarp(String txt, String pat) {
        // 位数
        int L = pat.length();
        // R
        int R = 256;
        // Q
        long Q = 1658598167;
        // 计算最高位的因子：R^(L-1)=R*R*R*...
        long RL = 1;
        for (int i = 1; i <= L - 1; i++) {
            RL = (RL * R) % Q;
        }
        // 计算pat的hash:时间复杂度O(L)
        long patHash = 0;
        for (int i = 0; i < L; i++) {
            patHash = (patHash * R + pat.charAt(i)) % Q;
        }
        // windowHash
        long windowHash = 0;
        // 滑动窗口
        int left = 0, right = 0;
        while (right < txt.length()) {
            windowHash = ((windowHash * R) % Q + txt.charAt(right)) % Q;
            right++;

            if (right - left == L) {
                if (windowHash == patHash) {
                    if (pat.equals(txt.substring(left, right))) {
                        return left;
                    }
                }
                windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
                // 模运算规则：X % Q == (X + Q) % Q，+Q 不影响windowHash结果，保证windowHash非负
                left++;
            }
        }
        return -1;
    }
}
