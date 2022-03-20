public class Main {

    final static double X = -10;
    final static double EPS = 0.0001;

    public static void main(String[] args) {




        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        System.out.println("SINX");
        System.out.println(sin.getValue(X, EPS));
        System.out.println(Math.sin(X));

        System.out.println("COSX");
        System.out.println(cos.getValue(X, EPS));
        System.out.println(Math.cos(X));

        Ln ln = new Ln();
        Log log = new Log(ln);

        System.out.println("LNX");
        System.out.println(ln.getValue(X, EPS));
        System.out.println(Math.log(X));

        System.out.println("LOGX");
        System.out.println(log.getValue(10, X, EPS));
        System.out.println(Math.log10(X));

        Tg tg = new Tg(sin, cos);
        System.out.println("TGX");
        System.out.println(tg.getValue(X, EPS));
        System.out.println(Math.tan(X));

        Csc csc = new Csc(sin);
        System.out.println("CSCX");
        System.out.println(csc.getValue(X, EPS));
        System.out.println(1/Math.sin(X));



        Function function = new Function(sin, tg, csc, log , ln);
        System.out.println(function.solve(X, EPS));
    }
}
