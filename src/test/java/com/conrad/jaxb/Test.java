package com.conrad.jaxb;

import java.io.StringWriter;
import java.net.URL;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;

public class Test {
    private static JAXBContext ctx = null;

    public static void main(String[] args) throws Exception {
        ctx = JAXBContext.newInstance("com.conrad.jaxb");
        URL inputUrl = Test.class.getResource("/decimal_test.xml");
        doTest(inputUrl);
    }

    public static void doTest(URL inputUrl) throws Exception {
        Unmarshaller unm = ctx.createUnmarshaller();
        Parent team = (Parent) unm.unmarshal(inputUrl);

        System.out.println(team.getAPR().getValue().getValue());

        Marshaller mar = ctx.createMarshaller();

        final StringWriter sw = new StringWriter();

        mar.marshal(team, sw);

        System.out.println(sw.toString());
    }
}