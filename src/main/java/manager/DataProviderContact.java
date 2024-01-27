package manager;

import models.Contacts;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contacts.builder()
                        .name("Nick")
                        .lastName("Jackson")
                        .email("erw@hu.na")
                        .address("Israel")
                        .phone("123")
                        .description("The best")

                        .build()
        });
        list.add(new Object[]{
                Contacts.builder()
                        .name("Nick")
                        .lastName("Jackson")
                        .email("erw@hu.na")
                        .address("Israel")
                        .phone("1234569632587414566558")
                        .description("The best")

                        .build()
        });
        list.add(new Object[]{
                Contacts.builder()
                        .name("Nick")
                        .lastName("Jackson")
                        .email("erw@hu.na")
                        .address("Israel")
                        .phone("fgthdfrtghju")
                        .description("The best")

                        .build()
        });
        list.add(new Object[]{
                Contacts.builder()
                        .name("Nick")
                        .lastName("Jackson")
                        .email("erw@hu.na")
                        .address("Israel")
                        .phone("")
                        .description("The best")

                        .build()
        });

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contacts.builder()
                        .name("Emma")
                        .lastName("Cold")
                        .phone("123658358888")
                        .email("ghj@yug.io")
                        .address("Argentina")
                        .description("all fields")

                        .build()
        });
        list.add(new Object[]{
                Contacts.builder()
                        .name("Tony")
                        .lastName("Cold")
                        .phone("12365854643")
                        .email("ghj@yug.io")
                        .address("Argentina")
                        .description("empty name")

                        .build()
        });

        return list.iterator();
    }
}
