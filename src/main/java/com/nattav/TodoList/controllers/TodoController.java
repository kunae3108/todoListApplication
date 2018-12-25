package com.nattav.TodoList.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nattav.TodoList.entities.InfTodoObj;
import com.nattav.TodoList.exception.TodoListExceptionHandler;
import com.nattav.TodoList.master.MasterClass;
import com.nattav.TodoList.repositories.TodoRepository;

@RestController
@RequestMapping("/api")
public class TodoController
{
	@Autowired
	TodoRepository infTodoObjRepository;

	@GetMapping("/todos")
	public List<InfTodoObj> getAlltodos()
	{
		// List<InfTodoObj> todoTask = InfTodoObjRepository.findAll();
		return infTodoObjRepository.findAll();
	}

	@PostMapping("/todos")
	public InfTodoObj createInfTodoObj(@Valid @RequestBody InfTodoObj _infTodoObj)
	{
		_infTodoObj.setStatusCode(MasterClass.TASK_STATUS.PENDING.getStatusCd());
		return infTodoObjRepository.save(_infTodoObj);
	}

	@GetMapping("/todos/{id}")
	public InfTodoObj getInfTodoObjById(@PathVariable(value = "id") Long _infTodoObjId)
	{
		return infTodoObjRepository.findById(_infTodoObjId)
				.orElseThrow(() -> new TodoListExceptionHandler("Todo task", "ID", _infTodoObjId));
	}

	@PutMapping("/todos/{id}")
	public InfTodoObj updateInfTodoObj(@PathVariable(value = "id") Long _infTodoObjId,
			@Valid @RequestBody InfTodoObj InfTodoObjDetails)
	{
		InfTodoObj infTodoObj = infTodoObjRepository.findById(_infTodoObjId)
				.orElseThrow(() -> new TodoListExceptionHandler("Todo task", "ID", _infTodoObjId));

		infTodoObj.setTitle(InfTodoObjDetails.getTitle());
		infTodoObj.setContent(InfTodoObjDetails.getContent());

		InfTodoObj updatedInfTodoObj = infTodoObjRepository.save(infTodoObj);
		return updatedInfTodoObj;
	}

	@PutMapping("/todos/{id}/{status}")
	public InfTodoObj ChangeStatusInfTodoObj(@PathVariable(value = "id") Long _InfTodoObjId, @PathVariable(value = "status") String _status)
	{
		InfTodoObj infTodoObj = infTodoObjRepository.findById(_InfTodoObjId)
				.orElseThrow(() -> new TodoListExceptionHandler("Todo task", "ID", _InfTodoObjId));
		

		if (MasterClass.isExistingTaskStatus(_status))
		{
			infTodoObj.setStatusCode(_status);
		}
		else
		{
			throw new TodoListExceptionHandler("Todo task", "Status Code", _status);
		}
		
		
		InfTodoObj updatedInfTodoObj = infTodoObjRepository.save(infTodoObj);
		return updatedInfTodoObj;
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long _InfTodoObjId) {
		InfTodoObj infTodoObj = infTodoObjRepository.findById(_InfTodoObjId)
	            .orElseThrow(() -> new TodoListExceptionHandler("Todo task", "ID", _InfTodoObjId));

	    infTodoObjRepository.delete(infTodoObj);

	    return ResponseEntity.ok().build();
	}
}
