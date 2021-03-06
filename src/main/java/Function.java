import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Function {

    private final Sin sin;
    private final Tg tg;
    private final Csc csc;
    private final Log log;
    private final Ln ln;

    public Function(Sin sin, Tg tg, Csc csc, Log log, Ln ln) {
        this.sin = sin;
        this.tg = tg;
        this.csc = csc;
        this.log = log;
        this.ln = ln;
    }

    public double solve(double x, double eps) {
        Double result;
        if (x <= 0) {
            result = Math.pow((((Math.pow(tg.getValue(x, eps),2) + csc.getValue(x,eps)) - csc.getValue(x, eps)) / sin.getValue(x,eps)), 2);
        } else {
            result = Math.pow((((Math.pow(log.getValue(10, x, eps), 3) - log.getValue(5, x, eps)) / log.getValue(5, x, eps)) + ln.getValue(x, eps)), 2);
        }
        if (result > 1000000000 || result < -1000000000){
            return Double.NaN;
        }
        return result;
    }
    public double writeResultToCSV(double x, double eps, Writer out) {
        double res = solve(x, eps);
        try{
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return res;
    }
}
