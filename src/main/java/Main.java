import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    final static double X = -10;
    final static double EPS = 0.0001;

    public static void main(String[] args) throws IOException {




        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Ln ln = new Ln();
        Log log = new Log(ln);
        Tg tg = new Tg(sin, cos);
        Csc csc = new Csc(sin);
        Function function = new Function(sin, tg, csc, log , ln);

        Writer writerSin = new FileWriter("src/main/resources/Sin.csv");
        Writer writerCos = new FileWriter("src/main/resources/Cos.csv");
        Writer writerTg = new FileWriter("src/main/resources/Tg.csv");
        Writer writerLog5 = new FileWriter("src/main/resources/Log5.csv");
        Writer writerLog10 = new FileWriter("src/main/resources/Log10.csv");
        Writer writerLn = new FileWriter("src/main/resources/Ln.csv");
        Writer writerCsc = new FileWriter("src/main/resources/Csc.csv");
        Writer writerFunction = new FileWriter("src/main/resources/Function.csv");

        for (double i = -10; i < 10; i+= 0.5){
            System.out.println("ХУЙ");
            sin.writeResultToCSV(i,EPS,writerSin);
            writerSin.flush();
            cos.writeResultToCSV(i,EPS,writerCos);
            writerCos.flush();
            tg.writeResultToCSV(i,EPS,writerTg);
            writerTg.flush();
            log.writeResultToCSV(10,i,EPS,writerLog10);
            writerLog10.flush();
            log.writeResultToCSV(5,i,EPS,writerLog5);
            writerLog5.flush();
            ln.writeResultToCSV(i,EPS,writerLn);
            writerLn.flush();
            csc.writeResultToCSV(i,EPS,writerCsc);
            writerCsc.flush();
            function.writeResultToCSV(i,EPS,writerFunction);
            writerFunction.flush();
        }

//        System.out.println("SINX");
//        System.out.println(sin.getValue(X, EPS));
//        System.out.println(Math.sin(X));
//        System.out.println("COSX");
//        System.out.println(cos.getValue(X, EPS));
//        System.out.println(Math.cos(X));
//        System.out.println("LNX");
//        System.out.println(ln.getValue(X, EPS));
//        System.out.println(Math.log(X));
//        System.out.println("LOGX");
//        System.out.println(log.getValue(10, X, EPS));
//        System.out.println(Math.log10(X));
//        System.out.println("TGX");
//        System.out.println(tg.getValue(X, EPS));
//        System.out.println(Math.tan(X));
//        System.out.println("CSCX");
//        System.out.println(csc.getValue(X, EPS));
//        System.out.println(1/Math.sin(X));
//
//
//
//        System.out.println("FUNCTION");
//        System.out.println(function.solve(X, EPS));
    }
}
