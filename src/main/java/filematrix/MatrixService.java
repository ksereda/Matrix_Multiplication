package filematrix;

public class MatrixService {

    public static double[][] matrixMultiplication(double[][] m1, double[][] m2) {

        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;

        if (m1ColLength != m2RowLength) {
            return null;
        }

        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];

        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return mResult;

    }

}
