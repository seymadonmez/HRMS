package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
	Position getByName(String name);
	Position findByName(String name);
	List<Position> getByNameStartsWith(String name);
} 
