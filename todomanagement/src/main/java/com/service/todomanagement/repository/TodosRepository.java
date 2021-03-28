package com.service.todomanagement.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.service.todomanagement.model.Todo;
public interface TodosRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUserName(String username);
}
