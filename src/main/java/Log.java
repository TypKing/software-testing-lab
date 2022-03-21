import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Log {

    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double getValue(double a, double b, double eps) {
        return ln.getValue(b, eps) / ln.getValue(a, eps);
    }

    public double writeResultToCSV(double a,double x, double eps, Writer out) {
        double res = getValue(a, x, eps);
        try{
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return res;
    }
}
