import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    final static double X = -10;
    final static double EPS = 0.0001;

    public static void main(String[] args) throws IOException {




        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        System.out.println("SINX");
        System.out.println(sin.getValue(X, EPS));
        System.out.println(Math.sin(X));
        Writer writerSin = new FileWriter("src/main/resources/Sin.csv");
        Writer writerCos = new FileWriter("src/main/resources/Cos.csv");
        Writer writerTg = new FileWriter("src/main/resources/Tg.csv");
        Writer writerLog5 = new FileWriter("src/main/resources/Log5.csv");
        Writer writerLog10 = new FileWriter("src/main/resources/Log10.csv");
        Writer writerLn = new FileWriter("src/main/resources/Ln.csv");
        Writer writerCsc = new FileWriter("src/main/resources/Csc.csv");
        Writer writerFunction = new FileWriter("src/main/resources/Function.csv");

        for (double i = -10; i < 10; i+= 0.5){

        }


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
