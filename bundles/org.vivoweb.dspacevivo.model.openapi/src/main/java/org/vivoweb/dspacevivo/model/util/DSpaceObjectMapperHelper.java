/**
 * 
 */
package org.vivoweb.dspacevivo.model.util;

import org.vivoweb.dspacevivo.model.Item;
import org.vivoweb.dspacevivo.model.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author heon
 *
 */
public class DSpaceObjectMapperHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static String map(Repository repo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(repo);
		return prettyStaff;
	}
	public static String map(Item item) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
		return prettyStaff;
	}
}
