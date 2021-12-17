package com.hhf.No_96_numTree;
//96. 不同的二叉搜索树

//动态规划的思想，以每一个节点都为根来构建二叉排序（搜索）树，这样保证数据不会重复
/*假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
        G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=

        当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
        f(i) = G(i-1)*G(n-i)

        综合两个公式可以得到 卡特兰数 公式
        G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)*/

public class numTreeTest {
    public int numTrees(int n) {
        //因为最开始的0作为辅助值
        int[] G= new int[n+1];
        G[0]=1;
        G[1]=1;
        //第一层循环代表  G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)，需要次数
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
