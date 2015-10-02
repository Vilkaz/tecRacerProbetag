package controller;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import dto.Header;
import dto.Person;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Vilius Kukanauskas
 * Package: controller
 * Date: 30.09.2015
 * Time: 1:53 PM
 */
public class HeaderController implements CSVEntryParser<Header> {
    public static Header getHeader() {
        return new HeaderController().parseEntry();
    }


    @Override
    public Header parseEntry(String... data) {
        Reader csvFile = CSVHelper.getInputStream();
        CSVReader<Header> headerCSVReader = new CSVReaderBuilder<Header>(csvFile).
                strategy(new CSVStrategy(',', '"', '#', false, true))
                .entryParser(
                        new HeaderController()).build();
        List<String> strings = null;
        try {
            strings = headerCSVReader.readHeader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        strings.add(0, "No.");
        return new Header(Arrays.asList(strings.get(0), strings.get(1),strings.get(5), strings.get(2)));

    }

}
