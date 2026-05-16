package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Testing");
        task.setCompleted(false);
    }

    @Test
    void shouldCreateTask() {
        when(taskRepository.save(task)).thenReturn(task);

        Task savedTask = taskService.createTask(task);

        assertNotNull(savedTask);
        assertEquals("Test Task", savedTask.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(1, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void shouldGetTaskById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task foundTask = taskService.getTaskById(1L);

        assertEquals(1L, foundTask.getId());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void shouldUpdateTask() {
        Task updated = new Task();
        updated.setTitle("Updated");
        updated.setDescription("Updated Desc");
        updated.setCompleted(true);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(updated);

        Task result = taskService.updateTask(1L, updated);

        assertEquals("Updated", result.getTitle());
        assertTrue(result.isCompleted());
    }

    @Test
    void shouldDeleteTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        doNothing().when(taskRepository).delete(task);

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).delete(task);
    }
}
