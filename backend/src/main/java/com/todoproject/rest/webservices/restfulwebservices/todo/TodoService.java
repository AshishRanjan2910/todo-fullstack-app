package com.todoproject.rest.webservices.restfulwebservices.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "admin", "Get AWS Certified",
							LocalDate.now().plusYears(10), false ));
		todos.add(new Todo(++todosCount, "admin", "Learn DevOps",
				LocalDate.now().plusYears(11), false ));
		todos.add(new Todo(++todosCount, "admin", "Learn Full Stack Development",
				LocalDate.now().plusYears(12), false ));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		if (todo == null) return new Todo();
		return todo;
	}

	public void updateTodo(Todo todo) {
		if(todo.getId() == -1){
			todos.add(new Todo(++todosCount, todo.getUsername(), todo.getDescription(),
					todo.getTargetDate(), todo.isDone()));
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
	}
}