package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {
	
	@Query("select m from Modalidad m where "
			+ "( :#{#fil.nombre} is '' or m.nombre like :#{#fil.nombre} ) and "
			+ "( :#{#fil.numHombres} is 0 or m.numHombres = :#{#fil.numHombres} ) and " 
			+ "( :#{#fil.numMujeres} is 0 or m.numMujeres = :#{#fil.numMujeres} ) and " 
			+ "( :#{#fil.edadMaxima} is 0 or m.edadMaxima = :#{#fil.edadMaxima} ) and " 
			+ "( :#{#fil.edadMinima} is 0 or m.edadMinima = :#{#fil.edadMinima} ) and "
			+ "( :#{#fil.sede} is '' or m.sede like :#{#fil.sede} ) and " 
			+ "( :#{#fil.idDeporte} is 0 or m.deporte.idDeporte = :#{#fil.idDeporte} ) ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil") FiltroModalidad obj);
	
}
