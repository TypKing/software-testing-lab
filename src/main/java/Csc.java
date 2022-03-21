import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

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
//        double epsx = eps/10;
//        double res1 = 1/sin.getValue(x, epsx);
//        while (Math.abs(res1 - res) > eps){
//            res = res1;
//            epsx /=10;
//            res1 = 1/sin.getValue(x, epsx);
//        }
//        res1 = 1/sin.getValue(x, epsx/2);
        return res;
    }
    public double writeResultToCSV(double x, double eps, Writer out) {
        double res = getValue(x, eps);
        try{
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return res;
    }
}
