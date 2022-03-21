import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    final static double EPS = 0.0001;

    public static void main(String[] args) throws IOException {

        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Ln ln = new Ln();
        Log log = new Log(ln);
        Tg tg = new Tg(sin, cos);
        Csc csc = new Csc(sin);
        Function function = new Function(sin, tg, csc, log , ln);
        Writer writerSin = new FileWriter("src/main/resources/CSVOutput/SinOut.csv");
        Writer writerCos = new FileWriter("src/main/resources/CSVOutput/CosOut.csv");
        Writer writerTg = new FileWriter("src/main/resources/CSVOutput/TgOut.csv");
        Writer writerLog5 = new FileWriter("src/main/resources/CSVOutput/Log5Out.csv");
        Writer writerLog10 = new FileWriter("src/main/resources/CSVOutput/Log10Out.csv");
        Writer writerLn = new FileWriter("src/main/resources/CSVOutput/LnOut.csv");
        Writer writerCsc = new FileWriter("src/main/resources/CSVOutput/CscOut.csv");
        Writer writerFunction = new FileWriter("src/main/resources/CSVOutput/FunctionOut.csv");
        for (double i = -10; i <= 10; i+= 0.2){
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

    }
}
