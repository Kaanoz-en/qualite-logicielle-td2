import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    private final LocalDate ANY_DEADLINE = LocalDate.of(2023, 4, 5);
    private final LocalDate ANY_OTHER_DEADLINE = LocalDate.of(2025, 4, 5);
    private final String ANY_TASK = "Laver la vaisselle";
    private final String ANY_OTHER_TASK = "Prendre une pause";

    private TaskList taskList;

    @BeforeEach
    public void createTaskList(){
        taskList = new TaskList();
    }
    @Test
    public void givenNoTask_whenGetTasksToDoByDeadline_thenListIsEmpty(){

       List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

       assertTrue(tasks.isEmpty());
    }

    @Test
    public void givenATask_whenGetTasksToDoByDeadline_thenReturnTheTask(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(ANY_TASK));

    }

    @Test
    public void givenATask_whenGetTasksToDoByDeadlineWithDifferentDeadline_thenListIsEmpty(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_OTHER_DEADLINE);

        assertTrue(tasks.isEmpty());

    }

    @Test
    public void givenATask_whenAddTwice_then_ThrowTaskAlreadyExistsException(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);

        Executable addSameTask = () -> taskList.addTask(ANY_TASK, ANY_DEADLINE);

        assertThrows(TaskAlreadyExistsException.class, addSameTask);
    }

    @Test
    public void givenATask_whenRemoveTask_thenRemoveOnlyTheTask(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);
        taskList.addTask(ANY_OTHER_TASK, ANY_DEADLINE);

        taskList.removeTask(ANY_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertTrue(tasks.contains(ANY_OTHER_TASK));
        assertFalse(tasks.contains(ANY_TASK));
    }

    @Test
    public void givenNoTask_whenRemoveTask_thenThrowTaskNotFoundException(){
        Executable removeTask = () -> taskList.removeTask(ANY_TASK, ANY_DEADLINE);

        assertThrows(ThrowTaskNotFoundException.class, removeTask);
    }

    @Test
    public void givenMultipleTaskWithSameDeadline_whenGetTasksToDoByDeadline_thenReturnAllTasks(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);
        taskList.addTask(ANY_OTHER_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertTrue(tasks.contains(ANY_TASK));
        assertTrue(tasks.contains(ANY_OTHER_TASK));
    }
}


