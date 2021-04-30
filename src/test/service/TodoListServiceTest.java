package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testAddTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Nyobain");
        todoListRepository.data[1] = new Todolist("Belajar Nyobain");
        todoListRepository.data[2] = new Todolist("Test Nyobain");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Nyobain Todolist");
        todoListService.addTodoList("Nyobain2 Todolist");
        todoListService.addTodoList("Nyobain3 Todolist");

        todoListService.showTodoList();

    }
}
