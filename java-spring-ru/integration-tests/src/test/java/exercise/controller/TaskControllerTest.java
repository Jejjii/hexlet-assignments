package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;
import org.springframework.test.web.servlet.ResultMatcher;

// END
@SpringBootTest
@AutoConfigureMockMvc
// BEGIN
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testShow() throws Exception {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle),() ->faker.lorem().sentence())
                .supply(Select.field(Task::getDescription), () ->faker.lorem().paragraph())
                .create();
        taskRepository.save(task);

        var request = get("/tasks/" + task.getId());
        var mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var jsonResponse = mvcResult.getResponse().getContentAsString();
        assertThatJson(jsonResponse).and(
                json -> json.node("title").isEqualTo(task.getTitle()),
                json -> json.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void testCreate() throws Exception {
        var newTaskData = new HashMap<>();
        newTaskData.put("title",faker.lorem().sentence());
        newTaskData.put("description",faker.lorem().paragraph());

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newTaskData));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        var savedTask = taskRepository.findByTitle((String) newTaskData.get("title"));
        assertThat(savedTask).isNotNull();
        var task = savedTask.orElseThrow(() -> new AssertionError("Task not found"));
        assertThat(task.getDescription()).isEqualTo(newTaskData.get("description"));
    }

    @Test
    public void testUpdate() throws Exception {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle),() ->faker.lorem().sentence())
                .supply(Select.field(Task::getDescription), () ->faker.lorem().paragraph())
                .create();
        taskRepository.save(task);

        var data = new HashMap<>();
        data.put("title"," new title");

        var request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(data.get("title"));

    }

    @Test
    public void testDelete() throws Exception {
        // Создание задачи
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().sentence())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
        taskRepository.save(task);

        // Отправка запроса на удаление
        var request = delete("/tasks/" + task.getId());
        mockMvc.perform(request)
                .andExpect(status().isOk()); // или isOk, в зависимости от вашего API

        // Проверка, что задача удалена
        var deletedTask = taskRepository.findById(task.getId());
        assertThat(deletedTask.isPresent()).isFalse();
    }


}
// END

