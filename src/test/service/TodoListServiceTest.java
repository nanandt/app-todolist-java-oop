package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
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

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Nyobain Todolist");
        todoListService.addTodoList("Nyobain2 Todolist");
        todoListService.addTodoList("Nyobain3 Todolist");

        todoListService.showTodoList();

        todoListService.removeTodoList(6);
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();


    }
}
