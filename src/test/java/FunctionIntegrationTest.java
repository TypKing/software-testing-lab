import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.*;


public class FunctionIntegrationTest {

    public final static double EPS = 0.0001;
    public final static double EPSTEST = 0.01;
    static Sin sMock;
    static Cos cMock;
    static Csc csMock;
    static Ln lMock;
    static Log lgMock;
    static Tg tMock;


    static Reader sinReader;
    static Reader cosReader;
    static Reader cscReader;
    static Reader lnReader;
    static Reader log5Reader;
    static Reader log10Reader;
    static Reader tgReader;


    @BeforeAll
    static void init() {
        sMock = Mockito.mock(Sin.class);
        cMock = Mockito.mock(Cos.class);
        csMock = Mockito.mock(Csc.class);
        lMock = Mockito.mock(Ln.class);
        lgMock = Mockito.mock(Log.class);
        tMock = Mockito.mock(Tg.class);


        try {
            sinReader = new FileReader("src/main/resources/Sin.csv");
            cosReader = new FileReader("src/main/resources/Cos.csv");
            cscReader = new FileReader("src/main/resources/Csc.csv");
            lnReader = new FileReader("src/main/resources/Ln.csv");
            log5Reader = new FileReader("src/main/resources/Log5.csv");
            log10Reader = new FileReader("src/main/resources/Log10.csv");
            tgReader = new FileReader("src/main/resources/Tg.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(sinReader);
            for (CSVRecord record : records) {
                Mockito.when(sMock.getValue(Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(cosReader);
            for (CSVRecord record : records) {
                Mockito.when(cMock.getValue(Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(cscReader);
            for (CSVRecord record : records) {
                Mockito.when(csMock.getValue(Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(lnReader);
            for (CSVRecord record : records) {
                Mockito.when(lMock.getValue(Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log5Reader);
            for (CSVRecord record : records) {
                Mockito.when(lgMock.getValue(5,Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(log10Reader);
            for (CSVRecord record : records) {
                Mockito.when(lgMock.getValue(10,Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(tgReader);
            for (CSVRecord record : records) {
                Mockito.when(tMock.getValue(Double.parseDouble(record.get(0)), EPS)).thenReturn(Double.parseDouble(record.get(1)));
            }

        } catch (IOException e) {
            System.out.println("Хуй");
        }


    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithAllMock(double value, double result){
        Function function = new Function(sMock,tMock,csMock,lgMock,lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithSin(double value, double result){
        Function function = new Function(new Sin(),new Tg(new Sin(),cMock),new Csc(new Sin()),lgMock,lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunction(double value, double result){
        Function function = new Function(new Sin(), new Tg(new Sin(),cMock), new Csc(new Sin()), lgMock, lMock);
        Assertions.assertEquals(result, function.solve(value, EPS),EPSTEST);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithTg(double value, double result){
        Function function = new Function(sMock,new Tg(sMock,cMock),csMock,lgMock,lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithCos(double value, double result){
        Function function = new Function(sMock,new Tg(sMock, new Cos(sMock)),csMock,lgMock,lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);
        // Отрицательные говно
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithCsc(double value, double result){
        Function function = new Function(sMock, tMock,new Csc(sMock),lgMock,lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);
        // Отрицательные говно
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithLn(double value, double result){
        Function function = new Function(sMock, tMock,csMock,new Log(new Ln()),new Ln());
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST*10);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithLog(double value, double result){
        Function function = new Function(sMock, tMock,csMock,new Log(lMock),lMock);
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST);
        // Положительные говно
    }

    @ParameterizedTest
    @CsvFileSource(resources = "Function.csv")
    void testFunctionWithAll(double value, double result){
        Function function = new Function(new Sin(), new Tg(new Sin(), new Cos(new Sin())),new Csc(new Sin()),new Log(new Ln()),new Ln());
        Assertions.assertEquals(result,function.solve(value,EPS),EPSTEST*10);
        // Провели интеграцию

    }

}
