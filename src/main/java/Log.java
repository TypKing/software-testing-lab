public class Log {

    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double getValue(double a, double b, double eps) {
        return ln.getValue(b, eps) / ln.getValue(a, eps);
    }
}
