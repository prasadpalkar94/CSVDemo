import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReadAndParseToBeanByPosition {
    private static final String SAMPLE_CSV_FILE_PATH = "src/dataWithOutHeader.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVUserwithPosition> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUserwithPosition.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUserwithPosition> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUserwithPosition csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }
}
