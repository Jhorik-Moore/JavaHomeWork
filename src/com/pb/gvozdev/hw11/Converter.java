package com.pb.gvozdev.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converter {

    public static void toJSON(Element element) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(element));

    }
    public static Object toJSONwrite(Element element) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(element);
    }
}
