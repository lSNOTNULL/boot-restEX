package org.example.bootrestex.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.bootrestex.model.domain.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Spring
@Mapper // MyBatis
public interface AnimalMapper {
    @Select("SELECT * FROM animal")
    List<Animal> findAll();

    @Insert("INSERT INTO animal (name, description, story) VALUES (#{name}, #{description}, #{story})")
    void insert(Animal animal);
}

