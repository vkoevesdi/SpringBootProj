package training.springbootproj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import training.springbootproj.dto.CreateToDoTDO;
import training.springbootproj.entity.ToDo;
import training.springbootproj.service.ToDoServiceImpl;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ToDoController.class)
class ToDoControllerTest {

    ToDo toDo1 = new ToDo(1L, "Wäsche waschen", false);
    ToDo toDo2 = new ToDo(null, "Zimmer putzen", true);
    ToDo toDo3 = new ToDo(null, "Pflanzen gießen", false);
    ToDo toDo4 = new ToDo(null, "Büro putzen", false);
    ToDo toDo5 = new ToDo(null, "Rasen mähen", true);

    List<ToDo> all = Arrays.asList(toDo1, toDo2, toDo3, toDo4, toDo5);

    List<ToDo> open = Arrays.asList(toDo1, toDo3, toDo4);
    List<ToDo> completed = Arrays.asList(toDo2, toDo5);


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ToDoServiceImpl toDoServiceImpl;

    @MockBean
    private ModelMapper modelMapper;



    @Test
    void createToDo() throws Exception {
        when(modelMapper.map(any(CreateToDoTDO.class), any())).thenReturn(toDo1);
        when(toDoServiceImpl.createToDo(toDo1)).thenReturn(toDo1);

        mockMvc.perform(post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(toDo1)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateToDo() {
    }

    @Test
    void deleteToDoById() throws Exception {
        doNothing().when(toDoServiceImpl).deleteTodoById(toDo1.getId());

        mockMvc.perform(delete("/todo/" + toDo1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void getToDoById() throws Exception {
        when(toDoServiceImpl.getToDoById(toDo1.getId())).thenReturn(toDo1);

        mockMvc.perform(get("/todo/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(toDo1.getId())))
                        .andExpect(status().isOk());
    }

    @Test
    void getAllToDo() {

    }

    @Test
    void findAllByCompletedIsTrue() {
    }

    @Test
    void findAllByCompletedIsFalse() {
    }

    @Test
    void countAllByCompletedIsTrue() {
    }

    @Test
    void countAllByCompletedIsFalse() {
    }
}