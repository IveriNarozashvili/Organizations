import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class Main {
    final static ModelMapper modelMapper = new ModelMapper();

    public static void main(String[] args) throws IOException {

        Map<String, Organization> organizationMap = new HashMap<>();
        final ObjectMapper mapper = new ObjectMapper();

        try {
            List<Object> object = mapper.readValue(new File("data.json"), new TypeReference<>() {
            });
            List<Organization> organizations = convert(object, Organization.class);
            for (Organization org : organizations) {
                organizationMap.put(org.getNameShort(), org);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Map.Entry<String, Organization> map : organizationMap.entrySet()) {
            System.out.println("\"" + map.getValue().getNameShort() + "\" - " + map.getValue().getDateOfEstablishment());
        }
        System.out.println("----------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate current = LocalDate.now();

        int count = 0;
        for (Map.Entry<String, Organization> map : organizationMap.entrySet()) {
            List<CennieBumagi> list = map.getValue().getCennieBumagi();
            for (CennieBumagi cb : list) {
                LocalDate localDate = LocalDate.parse(cb.getDateOfEnd(), formatter);
                if (localDate.isBefore(current)) {
                    count++;
                    System.out.println(cb.getCode() + ", " + cb.getDateOfEnd() + ", " + cb.getMoney() + ", " + cb.getNameOfOwner());
                }
            }
        }
        System.out.println("Количество ценных бумаг: " + count);
        System.out.println("----------");

        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();

        LocalDate localDate = format(date);

        for (Map.Entry<String, Organization> map : organizationMap.entrySet()) {
            LocalDate orgDate = LocalDate.parse(map.getValue().getDateOfEstablishment(), formatter);
            if (orgDate.isBefore(localDate)) {
                System.out.println("\"" + map.getValue().getNameFull() + "\" - " + map.getValue().getDateOfEstablishment());
            }
        }
        System.out.println("----------");

        Scanner scanner2 = new Scanner(System.in);
        String valuta = scanner2.nextLine();
        for (Map.Entry<String, Organization> karta : organizationMap.entrySet()) {
            List<CennieBumagi> list = karta.getValue().getCennieBumagi();
            for (CennieBumagi cb : list) {

                if (valuta.equals(cb.getMoney())) {
                    System.out.println(cb.getCode() + ", " + cb.getId());
                }
            }
        }
    }

    public static LocalDate format(String date) {
        String newDate = date.replaceAll("\\p{Punct}", "/");

        DateTimeFormatter formatter;
        if (newDate.length() > 8) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        } else
            formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return LocalDate.parse(newDate, formatter);
    }

    public static <S, T> List<T> convert(List<S> list, Class<T> dest) {
        if (list == null) {
            throw new IllegalArgumentException("Null parameters are not allowed");
        }
        return list
                .stream()
                .map(element -> modelMapper.map(element, dest))
                .collect(Collectors.toList());
    }
}
