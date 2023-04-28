package practice.array;

/**
 * 1、只要涉及到nSum问题，且数组有序，均可以用双指针技巧
 * 其他类似的题目：反转数组，也是用到一左一右双指针，不要求数组有序
 * 2、回文子串：跟一左一右指针不同，是从中心向两端扩散寻找回文子串；
 * 解题思路：以数组每个元素为基准分别寻找以 i为中心的最长回文子串s1、以i和i+1为中心的最长回文字串s2，更新res：res=longest(res, longest(s1,s2))
 */
public class BinarySearch {
}
