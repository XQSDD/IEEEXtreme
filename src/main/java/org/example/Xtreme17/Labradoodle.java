package org.example.Xtreme17;

import java.util.*;

/**
 * @author pc
 * @description 拉布拉多犬
 * Sporks、labradoodles 和 chocoholics 都是两个词混合成一个词的例子。您的挑战是根据字典中的单词判断一个词是否是混合词。
 * 在本挑战中，我们假设混合词的产生过程如下：
 * 1) 从字典中选择一个单词，然后从该单词中提取一个长度至少为 3 的前缀
 * 2) 选择另一个（可能是相同的）词典单词，并从该单词中提取一个长度至少为 3 的后缀
 * 将前缀和后缀合并，生成混合词。如果前缀结尾的字母与后缀开头的字母相同，则可以去掉其中一个匹配的字母。
 * @create 2023/10/28 17:55
 */
public class Labradoodle {
    /**
     * 输入：
     * 两个还只能输n和m，n行包含字典中的一个单词，仅有小写字母组成
     * 其余m行包含仅有小写字母组成的单词，这些单词可能是混合词
     * 输出：
     * 对每一个潜在的混合词，输出‘ambiguous’，如果有一个以上词典词对可以生成混合词
     * 输出‘none’没有词典词对可以生成混合词
     * 否则输出提供前缀的字典词和提供后缀的词典词
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //优化版
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            String mixWord = sc.next();
            if (mixWord.length() <= 4) {
                System.out.println("none");
                continue;
            }

            String preWord = null;
            String sufWord = null;
            int count = 0;
            for (int j = 3; j <= mixWord.length() - 2; j++) {
                String prefix1 = mixWord.substring(0, j);
                String prefix2 = mixWord.substring(0, j + 1);
                String suffix1 = mixWord.substring(j);
                String suffix2 = mixWord.substring(j - 1);

                for (String word1 : words) {
                    for (String word2 : words) {
                        if ((word1.startsWith(prefix1) && word2.endsWith(suffix1) && prefix1.length() >= 3 && suffix1.length() >= 3)
                                || (word1.startsWith(prefix1) && word2.endsWith(suffix2) && prefix1.length() >= 3 && suffix2.length() >= 3)
                                || (word1.startsWith(prefix2) && word2.endsWith(suffix1) && prefix2.length() >= 3 && suffix1.length() >= 3)) {
                            if (count == 0) {
                                preWord = word1;
                                sufWord = word2;
                                count++;
                            } else if (!preWord.equals(word1) || !sufWord.equals(word2)) {
                                count++;
                                break;
                            }
                        }
                    }
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 0) {
                System.out.println("none");
            } else if (count > 1) {
                System.out.println("ambiguous");
            } else {
                System.out.println(preWord + " " + sufWord);
            }
        }

        // String[] words = new String[n];
        // for (int i = 0; i < n; i++) {
        //     words[i] = sc.next();
        // }
        // String[] mixWords = new String[m];
        // for (int i = 0; i < m; i++) {
        //     mixWords[i] = sc.next();
        // }
        // // 依次对所有可能的混淆词进行比对
        // for (String mixWord : mixWords) {
        //     if (mixWord.length() <= 4) {
        //         System.out.println("none");
        //         continue;
        //     }
        //     String preWord = null;
        //     String sufWord = null;
        //     int count = 0;
        //     for (int i = 3; i <= mixWord.length() - 2; i++) {
        //         String prefix1 = mixWord.substring(0, i);
        //         String prefix2 = mixWord.substring(0, i+1);
        //         String suffix1 = mixWord.substring(i);
        //         String suffix2 = mixWord.substring(i - 1);
        //         // System.out.println(prefix1 + " " + suffix1 + " " + prefix2 + " " + suffix2);
        //         for (String word1 : words) {
        //             for (String word2 : words) {
        //                 if (word1.startsWith(prefix1) && word2.endsWith(suffix1) && prefix1.length() >= 3 && suffix1.length() >= 3) {
        //                     if (count == 0) {
        //                         preWord = word1;
        //                         sufWord = word2;
        //                         count++;
        //                     } else if (!preWord.equals(word1) || !sufWord.equals(word2)) {
        //                         count++;
        //                         break;
        //                     }
        //                 } else if (word1.startsWith(prefix1) && word2.endsWith(suffix2) && prefix1.length() >= 3 && suffix2.length() >= 3) {
        //                     if (count == 0) {
        //                         preWord = word1;
        //                         sufWord = word2;
        //                         count++;
        //                     } else if (!preWord.equals(word1) || !sufWord.equals(word2)) {
        //                         count++;
        //                         break;
        //                     }
        //                 } else if (word1.startsWith(prefix2) && word2.endsWith(suffix1) && prefix2.length() >= 3 && suffix1.length() >= 3) {
        //                     if (count == 0) {
        //                         preWord = word1;
        //                         sufWord = word2;
        //                         count++;
        //                     } else if (!preWord.equals(word1) || !sufWord.equals(word2)) {
        //                         count++;
        //                         break;
        //                     }
        //                 }
        //             }
        //             if (count > 1) {
        //                 break;
        //             }
        //         }
        //     }
        //     if (count == 0) {
        //         System.out.println("none");
        //     } else if (count > 1) {
        //         System.out.println("ambiguous");
        //     } else {
        //         System.out.println(preWord + " " + sufWord);
        //     }
        // }
    }
}
