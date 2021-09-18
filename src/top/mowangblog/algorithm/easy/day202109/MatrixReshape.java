package top.mowangblog.algorithm.easy.day202109;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * Algorithm-Daily-practice
 * 重塑矩阵
 *
 * @author : Xuan Li
 * @date : 2021-09-18 09:16
 **/
public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //二维数组的一维表示
        //每个元素 (i, j)(i,j) 映射到整数域内，并且它们按照行优先的顺序一一对应着 [0, mn)[0,mn) 中的每一个整数。形象化地来说，我们把这个二维数组「排扁」成了一个一维数组。如果读者对机器学习有一定了解，可以知道这就是 \texttt{flatten}flatten 操作。
        //
        //这样的映射即为：
        //
        //(i, j) \to i \times n+j
        //(i,j)→i×n+j
        //
        //同样地，我们可以将整数 xx 映射回其在矩阵中的下标，即
        //
        //\begin{cases} i = x ~/~ n \\ j = x ~\%~ n \end{cases}
        //{
        //i=x/n
        //j=x%n
        //
        //其中 // 表示整数除法，\%% 表示取模运算。
        //
        //那么题目需要我们做的事情相当于：
        //
        //将二维数组 \textit{nums}nums 映射成一个一维数组；
        //
        //将这个一维数组映射回 rr 行 cc 列的二维数组。
        //
        //我们当然可以直接使用一个一维数组进行过渡，但我们也可以直接从二维数组 \textit{nums}nums 得到 rr 行 cc 列的重塑矩阵：
        //
        //设 \textit{nums}nums 本身为 mm 行 nn 列，如果 mn \neq rcmn
        //
        // =rc，那么二者包含的元素个数不相同，因此无法进行重塑；
        //
        //否则，对于 x \in [0, mn)x∈[0,mn)，第 xx 个元素在 \textit{nums}nums 中对应的下标为 (x ~/~ n, x~\%~ n)(x/n,x%n)，而在新的重塑矩阵中对应的下标为 (x ~/~ c, x~\%~ c)(x / c,x % c)。我们直接进行赋值即可。
        //
        int m = mat.length;
        int n = mat[0].length;
        if (r * c != m * n) {
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            result[i/c][i%c] = mat[i/m][i%n];
        }
        return result;
    }
}
