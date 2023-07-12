package br.com.restwithspringboot.mapper.vo1;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;


public class MapperComModelMapper {

	private static ModelMapper mapper;
	
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
	
}
