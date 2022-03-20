public class Csc {

    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double getValue(double x, double eps){
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) {
            return Double.NaN;
        }
        double res = 1/sin.getValue(x, eps);
        double epsx = eps/10;
        double res1 = 1/sin.getValue(x, epsx);
        while (Math.abs(res1 - res) > eps){
            res = res1;
            epsx /=10;
            res1 = 1/sin.getValue(x, epsx);
        }
        res1 = 1/sin.getValue(x, epsx/2);
        return res1;
    }
}
