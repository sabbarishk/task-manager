package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;
    private TaskRequest sampleTaskRequest;
    private TaskResponse sampleTaskResponse;

    @BeforeEach
    void setUp() {
        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Test Task");
        sampleTask.setDescription("Test Description");
        sampleTask.setDueDate(java.time.LocalDateTime.now().plusDays(7));

        sampleTaskRequest = new TaskRequest();
        sampleTaskRequest.setTitle("Test Task");
        sampleTaskRequest.setDescription("Test Description");
        sampleTaskRequest.setDueDate(java.time.LocalDateTime.now().plusDays(7));

        sampleTaskResponse = new TaskResponse();
        sampleTaskResponse.setId(1L);
        sampleTaskResponse.setTitle("Test Task");
        sampleTaskResponse.setDescription("Test Description");
        sampleTaskResponse.setDueDate(java.time.LocalDateTime.now().plusDays(7));
    }

    @Test
    void getAllTasks_ShouldReturnAllTasks() {
        List<Task> tasks = Arrays.asList(sampleTask);
        when(taskRepository.findAll()).thenReturn(tasks);
        List<TaskResponse> result = taskService.getAllTasks();
        assertEquals(1, result.size());
        assertEquals("Test Task", result.get(0).getTitle());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getTaskById_WhenTaskExists_ShouldReturnTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        TaskResponse result = taskService.getTaskById(1L);
        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void getTaskById_WhenTaskDoesNotExist_ShouldThrowException() {
        when(taskRepository.findById(999L)).thenReturn(Optional.empty());
        assertThrows(TaskNotFoundException.class, () -> {
            taskService.getTaskById(999L);
        });
        verify(taskRepository, times(1)).findById(999L);
    }

    @Test
    void createTask_ShouldSaveAndReturnTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);
        TaskResponse result = taskService.createTask(sampleTaskRequest);
        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void searchTasks_ShouldReturnMatchingTasks() {
        List<Task> matchingTasks = Arrays.asList(sampleTask);
        when(taskRepository.findByTitleContainingIgnoreCase("test"))
                .thenReturn(matchingTasks);
        List<TaskResponse> result = taskService.searchTasks("test");
        assertEquals(1, result.size());
        assertEquals("Test Task", result.get(0).getTitle());
    }
}
