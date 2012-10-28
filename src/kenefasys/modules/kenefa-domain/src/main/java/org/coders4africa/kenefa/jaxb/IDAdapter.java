package org.coders4africa.kenefa.jaxb;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Maps a Long Id to a String Id as to be rendered in 
 * XML JAXB needs Long XmlIDs to be converted into strings values
 * 
 * @author Martial SOMDA
 * @since 1.0
 */
public class IDAdapter extends XmlAdapter<String, Long> {

    @Override
    public Long unmarshal(String stringValue) throws Exception {
        return DatatypeConverter.parseLong(stringValue);
    }

    @Override
    public String marshal(Long longValue) throws Exception {
        return DatatypeConverter.printLong(longValue);
    }
    
}
