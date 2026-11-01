package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertFalse(simpleTask.matches("Купить"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Мясо"));
    }

    @Test
    public void shouldMatchMeetingByTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобайка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("Выкатка 4й версии"));
    }

    @Test
    public void shouldMatchMeetingByProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобайка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("Нетобайка"));
        Assertions.assertFalse(meeting.matches("Другое"));
    }
}