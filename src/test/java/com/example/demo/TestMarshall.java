package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;

import generated.Shiporder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class TestMarshall
{
    @Test
    public void unmashallingTest() throws JAXBException, FileNotFoundException
    {
        var jaxbContext = JAXBContext.newInstance(Shiporder.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        var orderId = "1";
        var person = "Jeremy Blake";
        var person2 = "Person 2";


        var shipOrder = new Shiporder();
        shipOrder.setOrderid("1");
        shipOrder.setOrderperson("Jeremy Blake");
        var shipTo = new Shiporder.Shipto();
        shipTo.setAddress("1234 Something Lane");
        shipTo.setCity("San Diego");
        shipTo.setCountry("US");
        shipTo.setName("Person 2");
        shipOrder.setShipto(shipTo);
        javax.xml.transform.Result result = null;
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/shiporder.txt");
        marshaller.marshal(shipOrder, new StreamResult(fos));

        FileInputStream fis = new FileInputStream("src/test/java/resources/shiporder.txt");
        var unmarshalledObject = unmarshaller.unmarshal(new StreamSource(fis));



        
    }
}