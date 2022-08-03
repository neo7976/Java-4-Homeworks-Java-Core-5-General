import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class MainCSV {
    public static void main(String[] args) {

//        // Создаем запись
//        String[] employee = "1,David,Miller,Australia,30".split(",");
//// Создаем экземпляр CSVWriter
//        try (CSVWriter writer = new CSVWriter(new FileWriter("lessonCSV/src/main/resources/staff.csv"))) {
//// Записываем запись в файл
//            writer.writeNext(employee);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        // Создаем экземпляр CSVWriter
//// Разделитель по умолчанию - запятая
//// Символ выражения по умолчанию - двойные кавычки
//        try (CSVReader reader = new CSVReader(new java.io.FileReader("lessonCSV/src/main/resources/staff.csv"))) {
//// Массив считанных строк
//            String[] nextLine;
//// Читаем CSV построчно
//            while ((nextLine = reader.readNext()) != null) {
//// Работаем с прочитанными данными.
//                System.out.println(java.util.Arrays.toString(nextLine));
//            }
//        } catch (IOException | CsvValidationException e) {
//            e.printStackTrace();
//        }
//
//
//        // В приведенном выше примере считывается весь CSV-файл, а затем строки
//        // перебираются по очереди
//        try (CSVReader reader = new CSVReader(new FileReader("lessonCSV/src/main/resources/staff.csv"))) {
//            // Читаем все строки за один раз
//            List<String[]> allRows = reader.readAll();
//            // Пройдемся по массиву строк
//            for (String[] row : allRows) {
//                // Выполним операцию над записью
//                System.out.println(Arrays.toString(row));
//            }
//
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
//
//
//
//        // Создаем запись
//        String[] employee = "5,David,Feezor,USA,40".split(",");
//// Создаем экземпляр CSVWriter
//        try (CSVWriter writer = new CSVWriter(new FileWriter("lessonCSV/src/main/resources/staff.csv", true))) {
//// Записываем запись в файл
//            writer.writeNext(employee);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        // Создадим пользовательский парсер
//        CSVParser parser = new CSVParserBuilder()
//                .withSeparator('|')
//                .build();
//        // Создадим считыватель через билдер
//        try (CSVReader reader = new CSVReaderBuilder(new FileReader("lessonCSV/src/main/resources/staff_custom.csv"))
//                .withCSVParser(parser)
//                .build()) {
//
//            String[] nextLine;
//            while ((nextLine = reader.readNext()) != null) {
//                System.out.println(Arrays.toString(nextLine));
//            }
//        } catch (IOException | CsvValidationException e) {
//            e.printStackTrace();
//        }
//
//
        //parsing/deserialization
        try (CSVReader csvReader = new CSVReader(new FileReader("lessonCSV/src/main/resources/staff.csv"))) {

            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            List<Employee> staff = csv.parse();
            staff.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        //serialization
//        List<Employee> staff = new ArrayList<>();
//        staff.add(new Employee(1, "Nikita", "Shumskii", "Russia", 25));
//        staff.add(new Employee(2, "Pavel", "Shramko", "Russia", 23));
//
//        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
//        strategy.setType(Employee.class);
//        strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");
//
//        try (Writer writer = new FileWriter("lessonCSV/src/main/resources/staff.csv")) {
//
//            StatefulBeanToCsv<Employee> sbc = StatefulBeanToCsvBuilder<Employee>(writer)
//                    .withMappingStrategy(strategy)
//                    .build();
//            sbc.write(staff);
//        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
//            e.printStackTrace();
//        }


    }
}
