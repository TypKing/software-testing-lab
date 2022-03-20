public class Tg {

    private final Sin sin;
    private final Cos cos;

    public Tg(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double getValue(double x, double eps){
        double cosx = cos.getValue(x,eps);
        double sinx = sin.getValue(x,eps);
        if (cosx == 0 || Double.isNaN(cosx) || sinx == 1 || Double.isNaN(sinx))
            return Double.NaN;
        double epsx = eps;
        double res = sinx/cosx;
        epsx /= 1000;
        cosx = cos.getValue(x, epsx);
        sinx = sin.getValue(x, epsx);
        double res1 = sinx/cosx;
        System.out.println(res1 + " - res1 " + res + " -res");
        while (Math.abs(res1 - res) > eps){
            res = res1;
            epsx /= 2;
            cosx = cos.getValue(x, epsx);
            sinx = sin.getValue(x, epsx);
            res1 = sinx/cosx;
        }
        epsx /= 2;
        cosx = cos.getValue(x, epsx);
        sinx = sin.getValue(x, epsx);
        res1 = sinx/cosx;
        return res1;
    }
}
