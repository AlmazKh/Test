package ru.itis;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.bytebuddy.utility.RandomString;
import sun.security.util.Length;

import java.io.File;
import java.io.IOException;

public class DataGenerator {
    private static final int length = 9;

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        User user = User.builder()
                .login(RandomString.make(length))
                .password(RandomString.make(length))
                .build();

        TxtFile txtFile = TxtFile.builder()
                .name(RandomString.make(length))
                .build();

//        xmlMapper.writeValue(new File("testLoginData.xml"), user);
        xmlMapper.writeValue(new File("testFileData.xml"), txtFile);
    }
}
